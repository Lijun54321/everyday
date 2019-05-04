import java.util.HashMap;
import java.util.Map;

/**
 * Class leetCode3_无重复字符的最长子串 ...
 *
 * @author LiJun
 * Created on 2019/5/1
 */
public class leetCode3_无重复字符的最长子串 {
    static class Solution {
        /**
         * 滑动窗口的方法
         *
         * @param s
         * @return
         */
        public int lengthOfLongestSubstring(String s) {
            int ans = 0;
            int begin = 0;
            int end = 0;
            int[] hash = new int[128];
            while (begin < s.length() && end < s.length()) {
                if (hash[s.charAt(end)] == 0) {
                    hash[s.charAt(end)] = 1;
                    end++;
                    ans = (end - begin) > ans ? (end - begin) : ans;
                } else {
                    hash[s.charAt(begin)] = 0;
                    begin++;
                }
            }
            return ans;
        }

        public int lengthOfLongestSubstring1(String s) {
            int n = s.length(), ans = 0;
            Map<Character, Integer> map = new HashMap<>();
            for (int j = 0, i = 0; j < n; j++) {
                if (map.containsKey(s.charAt(j))) {
                    i = Math.max(map.get(s.charAt(j)), i);
                }
                ans = Math.max(ans, j - i + 1);
                map.put(s.charAt(j), j + 1);
            }
            return ans;
        }

    }
}
/*
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
