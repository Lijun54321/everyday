package 搜索;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class 单词接龙2 ...
 *
 * @author LiJun
 * Created on 2019/5/3
 */
public class 单词接龙2 {
    static class Solution {
        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            // 用邻接表来构造图
            Map<String, List<String>> map = new HashMap<>();
            // 初始化邻接表
            // 标记是否有beginWord
            boolean flag = false;
            for (int i = 0; i < wordList.size(); i++) {
                if(wordList.get(i).equals(beginWord)){
                    flag = true;
                }
                map.put(wordList.get(i), new ArrayList<>());
            }
            if(!flag){
                wordList.add(beginWord);
                map.put(beginWord, new ArrayList<>());
            }
            for (int i = 0; i < wordList.size(); i++) {
                for (int j = i + 1; j < wordList.size(); j++) {
                    if (connect(wordList.get(i), wordList.get(j))) {
                        map.get(wordList.get(i)).add(wordList.get(j));
                        map.get(wordList.get(j)).add(wordList.get(i));
                    }
                }
            }
            List<Node> q = new ArrayList<>();
            List<Integer> endPos = new ArrayList<>();
            bfs(beginWord, endWord, map, q, endPos);
            List<List<String>> result = new ArrayList<>();
            for(int i = 0; i < endPos.size(); i++){
                int pos = endPos.get(i);
                List<String> path = new ArrayList<>();
                while(pos != -1){
                    path.add(0, q.get(pos).val);
                    pos = q.get(pos).pre;
                }
                result.add(path);
            }
            return result;
        }

        private void bfs(String begin, String end, Map<String, List<String>> map,
                         List<Node> q, List<Integer> endPos) {
            Map<String, Integer> visit = new HashMap<>();
            // 到达endWord 的最小步数
            int minStep = 0;
            // 起始单词的前驱为 - 1
            q.add(new Node(begin, -1, 1));
            // 标记起始步数为1
            visit.put(begin, 1);
            int front = 0;
            while (front < q.size()) {
                Node node = q.get(front);
                // step > minStep 时，代表所有搜索到达终点的路径都搜索完成了
                if (minStep != 0 && node.step > minStep) {
                    break;
                }
                // 搜索到结果是，记录到达终点的最小步数
                if (node.val.equals(end)) {
                    minStep = node.step;
                    endPos.add(front);
                }
                List<String> list = map.get(node.val);
                for (String s : list) {
                    // 节点是最小步数，或者没被访问
                    if (!visit.containsKey(s) || visit.get(s) == node.step + 1) {
                        q.add(new Node(s, front, node.step + 1));
                        visit.put(s, node.step + 1);
                    }
                }
                front++;
            }


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

        class Node {
            String val;
            int pre;
            int step;

            public Node(String val, int pre, int size) {
                this.val = val;
                this.pre = pre;
                this.step = size;
            }

            @Override
            public String toString() {
                return "Node{" +
                        "val='" + val + '\'' +
                        ", pre=" + pre +
                        ", step=" + step +
                        '}';
            }
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
        System.out.println(solution.findLadders(beginWord, endWord, list));
    }
}
/*
给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：

每次转换只能改变一个字母。
转换过程中的中间单词必须是字典中的单词。
说明:

如果不存在这样的转换序列，返回一个空列表。
所有单词具有相同的长度。
所有单词只由小写字母组成。
字典中不存在重复的单词。
你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
示例 1:

输入:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

输出:
[
  ["hit","hot","dot","dog","cog"],
  ["hit","hot","lot","log","cog"]
]
示例 2:

输入:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

输出: []

解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
 */