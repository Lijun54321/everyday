/**
 * Class leetCode680_验证回文串2 ...
 *
 * @author LiJun
 * Created on 2019/5/1
 */
public class leetCode680_验证回文串2 {
    class Solution {
        public boolean validPalindrome(String s) {
            int start = 0;
            int end = s.length() - 1;
            while (start < end) {
                if (s.charAt(start) != s.charAt(end)) {
                    return isPalindrome(s, start + 1, end) || isPalindrome(s, start, end - 1);
                }
                start++;
                end--;
            }

            return true;
        }

        private boolean isPalindrome(String s, int i, int end) {
            while (i < end) {
                if (s.charAt(i++) != s.charAt(end--))
                    return false;
            }
            return true;
        }
    }

}
/*
给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。

示例 1:

输入: "aba"
输出: True
示例 2:

输入: "abca"
输出: True
解释: 你可以删除c字符。
注意:

字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 */