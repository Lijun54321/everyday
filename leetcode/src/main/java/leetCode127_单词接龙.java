import java.util.*;

/**
 * Class 单词接龙 ...
 *
 * @author LiJun
 * Created on 2019/5/3
 */
public class leetCode127_单词接龙 {
    static class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            // 用邻接表来构造图

            Map<String, List<String>> map = new HashMap<>();
            // 可能wordList 里面没有beginWord, 添加进去。
            wordList.add(beginWord);
            // 初始化邻接表
            for (int i = 0; i < wordList.size(); i++) {
                map.put(wordList.get(i), new ArrayList<>());
            }

            for (int i = 0; i < wordList.size(); i++) {
                for (int j = i + 1; j < wordList.size(); j++) {
                    if (connect(wordList.get(i), wordList.get(j))) {
                        map.get(wordList.get(i)).add(wordList.get(j));
                        map.get(wordList.get(j)).add(wordList.get(i));
                    }
                }
            }
            return bfs(beginWord, endWord, map, new HashSet<>(), new LinkedList<>());
        }

        class Node {
            String val;
            int size;

            public Node(String val, int size) {
                this.val = val;
                this.size = size;
            }
        }

        private int bfs(String beginWord, String endWord, Map<String,
                List<String>> map, Set<String> visited, Queue<Node> queue) {

            queue.offer(new Node(beginWord, 1));
            visited.add(beginWord);
            while (!queue.isEmpty()) {
                Node temp = queue.poll();
                if (temp.val.equals(endWord)) {
                    return temp.size;
                }
                List<String> list = map.get(temp.val);
                for (String s : list) {
                    if (!visited.contains(s)) {
                        queue.offer(new Node(s, temp.size + 1));
                        visited.add(s);
                    }
                }
            }
            return 0;
        }

        private boolean connect(String word1, String word2) {
            int cnt = 0;
            for (int i = 0; i < word1.length(); i++) {
                if (word1.charAt(i) != word2.charAt(i)) {
                    cnt++;
                }
            }
            return cnt == 1;
        }
    }

    public static void main(String[] args) {
        String beginWord = "hit",
                endWord = "cog";

        String[] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};
        List<String> list = new ArrayList<>();
        for (String s : wordList) {
            list.add(s);
        }
        Solution solution = new Solution();
        solution.ladderLength(beginWord, endWord, list);
        System.out.println(solution.ladderLength(beginWord, endWord, list));
    }
}

/*
给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：

每次转换只能改变一个字母。
转换过程中的中间单词必须是字典中的单词。
说明:

如果不存在这样的转换序列，返回 0。
所有单词具有相同的长度。
所有单词只由小写字母组成。
字典中不存在重复的单词。
你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
示例 1:

输入:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

输出: 5

解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     返回它的长度 5。
示例 2:

输入:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

输出: 0

解释: endWord "cog" 不在字典中，所以无法进行转换。
 */