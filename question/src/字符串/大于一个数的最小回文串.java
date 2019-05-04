package 字符串;


import java.util.Scanner;

/**
 * Class 大于一个数的最小回文串 ...
 *
 * @author LiJun
 * Created on 2019/4/13
 */
public class 大于一个数的最小回文串 {

    public static class Solution {
        public String firstBiggerPalindrome(String n) {
            n = String.valueOf(Integer.parseInt(n));
            // 全 9 的青睐
            if (n.matches("9+")) {
                return String.valueOf(Integer.parseInt(n) + 2);
            }
            // 个位数情况
            if (n.length() == 1) {
                return String.valueOf(Integer.parseInt(n) + 1);
            }
            // 这里开始处理
            StringBuilder left = new StringBuilder();
            StringBuilder right = new StringBuilder();
            StringBuilder res = new StringBuilder();
            int len = n.length();
            // 长度是奇数位的情况
            if ((len & 1) == 1) {
                // 左右分开
                left.append(n, 0, len >> 1);
                right.append(n.substring((len >> 1) + 1));
                // 如果左边反转数字大于右边，直接反转
                if (isLeftReverseBiggerRight(left.toString(), right.toString())) {
                    res.append(left);
                    res.append(n.charAt(len >> 1));
                    res.append(left.reverse().toString());
                } else { // 左边 + 中间数组+1 再反转
                    left.append(n.charAt(len >> 1));
                    int num = Integer.parseInt(left.toString()) + 1;
                    left.setLength(0);
                    left.append(num);
                    res.append(num);
                    res.append(left.deleteCharAt(left.length() - 1).reverse().toString());
                }
            } else { // 偶数情况
                left.append(n, 0, len >> 1);

                right.append(n.substring(len >> 1));
                if (!isLeftReverseBiggerRight(left.toString(), right.toString())) {
                    int num = Integer.parseInt(left.toString()) + 1;
                    left.setLength(0);
                    left.append(num);

                }
                res.append(left.toString());
                res.append(left.reverse().toString());
            }
            return res.toString();
        }

        private boolean isLeftReverseBiggerRight(String left, String right) {
            StringBuilder sb = new StringBuilder(left);
            return sb.reverse().toString().compareTo(right) > 0;
        }
    }

    /**
     * 判断一个数字是不是回文数字(最后的测试代码使用)
     *
     * @param num
     * @return
     */
    private static boolean isPalindrome(int num) {
        String str = String.valueOf(num);
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String str = scanner.nextLine();
            System.out.println(solution.firstBiggerPalindrome(str));
        }
    }
}

