/**
 * Class day25_无重复字符的最长子串 ...
 *
 * @author LiJun
 * Created on 2019/4/8
 */
public class day25_无重复字符的最长子串 {

    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            int[] hash = new int[128];
            int max = 0;
            int i = 0, j = 0;
            while (i < s.length() && j < s.length()) {
                if (hash[s.charAt(j)] == 0) {
                    hash[s.charAt(j)] = 1;
                    j++;
                    max = (j - i) > max ? (j - i) : max;
                } else {
                    hash[s.charAt(i)] = 0;
                    i++;
                }
            }
            return max;
        }
    }
}
