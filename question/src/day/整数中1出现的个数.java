package day;

/**
 * Class 整数中1出现的个数 ...
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
 * 但是对于后面问题他就没辙了。ACMer希望你们帮帮他,
 * 并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 *
 * @author LiJun
 * Created on 2019/4/16
 */
public class 整数中1出现的个数 {
    /**
     * 这道题属于未完成状态
     */
    public static class Solution {
        public int NumberOf1Between1AndN_Solution(int n) {
            int len = String.valueOf(n).length();
            // 得到n的长度，把它长度-1 中的1的个数算出来
            int num = (int) Math.pow(10, len - 1);
            int result = 0;
            for (int i = 1; i <= len; i++) {
                result += getNum(i);
            }
            return 0;
        }

        private int getNum(int i) {
            if(i == 0){
                return 0;
            }
            if (i == 1) {
                return 1;
            }
            return (int) (Math.pow(10, i - 1)) + getNum(i - 1);
        }
    }

    public static void main(String[] args) {
        /*Solution solution = new Solution();

        System.out.println(solution.getNum(2));*/
    }
}
