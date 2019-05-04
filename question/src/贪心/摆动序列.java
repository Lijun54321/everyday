package 贪心;

/**
 * Class 摆动序列 ...
 *
 * @author LiJun
 * Created on 2019/4/25
 */
public class 摆动序列 {
    static class Solution {
        public int wiggleMaxLength(int[] nums) {
            if (nums.length < 2) {
                return nums.length;
            }
            final int begin = 0;
            final int up = 1;
            final int down = 2;
            int state = begin;
            int maxLen = 1;
            for (int i = 1; i < nums.length; i++) {
                switch (state) {
                    case begin:
                        if (nums[i - 1] < nums[i]) {
                            state = up;
                            maxLen++;
                        } else if (nums[i - 1] > nums[i]) {
                            state = down;
                            maxLen++;
                        }
                        break;
                    case up:
                        if (nums[i - 1] > nums[i]) {
                            state = down;
                            maxLen++;
                        }
                        break;
                    case down:
                        if (nums[i - 1] < nums[i]) {
                            state = up;
                            maxLen++;
                        }
                        break;
                    default:
                        break;
                }
            }
            return maxLen;
        }

        public int wiggleMaxLength1(int[] nums) {
            int n = nums.length;
            if (n < 2) {
                return n;
            }
            int up = 1;
            int down = 1;
            for (int i = 1; i < n; i++) {
                if (nums[i] > nums[i - 1]) {
                    up = down + 1;
                }
                if (nums[i] < nums[i - 1]) {
                    down = up + 1;
                }
            }
            return Math.max(up, down);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        Solution solution = new Solution();
        System.out.println(solution.wiggleMaxLength1(nums));
    }
}