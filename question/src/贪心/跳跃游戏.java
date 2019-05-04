package 贪心;

/**
 * Class 跳跃游戏 ...
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
 * 示例 2:
 *
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ，
 * 所以你永远不可能到达最后一个位置。
 *
 * @author LiJun
 * Created on 2019/4/27
 */
public class 跳跃游戏 {
    static class Solution {
        public boolean canJump(int[] nums) {
            int[] index = new int[nums.length];
            // 计算出相应的index 即到达的最大地方
            for (int i = 0; i < nums.length; i++) {
                index[i] = i + nums[i];
            }
            // 尝试跳
            int jump = 0;
            int maxIndex = index[0];
            while (jump < index.length && jump <= maxIndex) {
                if (maxIndex < index[jump]) {
                    maxIndex = index[jump];
                }
                jump ++;
            }
            return jump >= nums.length;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canJump(new int[]{1}));
    }

}
