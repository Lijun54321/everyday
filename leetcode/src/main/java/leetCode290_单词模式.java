import java.util.HashMap;
import java.util.HashSet;

/**
 * Class 单词模式 ...
 *
 * @author LiJun
 * Created on 2019/5/3
 */
public class leetCode290_单词模式 {
    static class Solution {
        /**
         * 思路就是 hash 存值
         * @param pattern
         * @param str
         * @return
         */
        public boolean wordPattern(String pattern, String str) {
            HashMap<Character, String> hashMap = new HashMap<>();
            HashSet<String> set = new HashSet<>();
            String[] nums = str.split(" ");
            if(nums.length != pattern.length()){
                return false;
            }
            for (int i = 0; i < nums.length; i++) {
                if (hashMap.containsKey(pattern.charAt(i))) {
                    if (!nums[i].equals(hashMap.get(pattern.charAt(i)))) {
                        return false;
                    }
                }else {
                    if (!set.add(nums[i])) {
                        return false;
                    } else {
                        hashMap.put(pattern.charAt(i), nums[i]);
                    }
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.wordPattern("abba", "dog cat cat dog"));
    }

}
/*
给定一种 pattern(模式) 和一个字符串 str ，判断 str 是否遵循相同的模式。

这里的遵循指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应模式。

示例1:

输入: pattern = "abba", str = "dog cat cat dog"
输出: true
示例 2:

输入:pattern = "abba", str = "dog cat cat fish"
输出: false
示例 3:

输入: pattern = "aaaa", str = "dog cat cat dog"
输出: false
示例 4:

输入: pattern = "abba", str = "dog dog dog dog"
输出: false
说明:
你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
 */