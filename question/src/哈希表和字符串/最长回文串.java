package 哈希表和字符串;

/**
 * Class 最长回文串 ...
 *
 * @author LiJun
 * Created on 2019/5/3
 */
public class 最长回文串 {

    class Solution {
        /**
         * 思路就是拿hash来存储字符，如果长度 有 2 就可以拿来构造。
         * 如果，存在奇数，那么就可以拿来做中间字符，且只能出现一次
         * @param s
         * @return
         */
        public int longestPalindrome(String s) {
            int[] hash = new int[128];
            for (int i = 0; i < s.length(); i++) {
                hash[s.charAt(i)]++;
            }
            int flag = 0;
            int result = 0;
            for (int i = 0; i < hash.length; i++) {
                result += hash[i] / 2;
                if (flag == 0 && hash[i] % 2 == 1) {
                    flag = 1;
                }
            }
            return (result << 1) + flag;
        }
    }

}
/*
给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。

在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。

注意:
假设字符串的长度不会超过 1010。

示例 1:

输入:
"abccccdd"

输出:
7

解释:
我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。

 */