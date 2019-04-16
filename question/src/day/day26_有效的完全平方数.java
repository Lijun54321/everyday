package day;

/**
 * Class day26_有效的完全平方数 ...
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 * <p>
 * 说明：不要使用任何内置的库函数，如  sqrt。
 *
 * @author LiJun
 * Created on 2019/4/12
 */
public class day26_有效的完全平方数 {

    static class Solution {
        public boolean isPerfectSquare(int num) {
            int sum = 1;
            while (num > 0) {
                num -= sum;
                sum += 2;
            }
            return num == 0;
        }

        public boolean isPerfectSquare1(int num) {

            int min = 0;
            int max = num;
            while (min <= max) {
                int mid = (min + max) >> 1;
                if (mid == num * 1.0 / mid) {
                    return true;
                } else if (mid > num * 1.0 / mid) {
                    max = mid - 1;
                } else {
                    min = mid + 1;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPerfectSquare1(1));
        System.out.println(solution.isPerfectSquare1(14));
    }
}
