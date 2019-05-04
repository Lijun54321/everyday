import java.util.Stack;

/**
 * Class 最长上升子序列 ...
 *
 * @author LiJun
 * Created on 2019/5/4
 */
public class leetCode300_最长上升子序列 {
    static class Solution {
        public int lengthOfLIS(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            if (nums.length == 1) {
                return 1;
            }
            int[] dp = new int[nums.length];
            dp[0] = 1;
            // 记录长度
            int lts = 1;
            for (int i = 1; i < nums.length; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j] && dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                    }
                }
                lts = lts > dp[i] ? lts : dp[i];
            }
            return lts;
        }

        public int lengthOfLIS1(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            if (nums.length == 1) {
                return 1;
            }
            Stack<Integer> stack = new Stack<>();
            stack.push(nums[0]);
            for (int i = 1; i < nums.length; i++) {
                if (stack.isEmpty() || stack.peek() < nums[i]) {
                    stack.push(nums[i]);
                } else {
                    // 可以把这改成二分查找，速度还要快带你
                    for (int j = 0; j < stack.size(); j++) {
                        if(stack.get(j) >= nums[i]){
                            stack.set(j, nums[i]);
                            break;
                        }
                    }
                }
            }
            return stack.size();
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLIS1(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }
}
/*
给定一个无序的整数数组，找到其中最长上升子序列的长度。

示例:

输入: [10,9,2,5,3,7,101,18]
输出: 4
解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
说明:

可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
你算法的时间复杂度应该为 O(n2) 。
进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 */