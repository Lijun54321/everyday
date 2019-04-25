package day;

/**
 * Class 判断删除一个字符能否变成回文串 ...
 *
 * @author LiJun
 * Created on 2019/4/25
 */
public class 判断删除一个字符能否变成回文串 {
    class Solution {
        public boolean validPalindrome(String s) {
            int i = -1;
            int j = s.length();
            while (++i < --j) {
                if (s.charAt(i) != s.charAt(j)) {
                    return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
                }
            }
            return true;

        }

        public boolean isPalindrome(String s, int i, int j) {
            while (i < j) {
                if (s.charAt(i++) != s.charAt(j--)) {
                    return false;
                }
            }
            return true;
        }
    }
}
