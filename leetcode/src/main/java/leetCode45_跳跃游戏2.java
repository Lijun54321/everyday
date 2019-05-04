/**
 * Class leetCode45_跳跃游戏2 ...
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例:
 *
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 说明:
 * 假设你总是可以到达数组的最后一个位置。
 *
 * @author LiJun
 * Created on 2019/4/27
 */
public class leetCode45_跳跃游戏2 {

    class Solution {
        public int jump(int[] nums) {
            if(nums.length < 2){
                return 0;
            }
            // 思路就是 记录当前最大能达到的位置，然后向这个位置逼近
            // 中途记录后面我们能够达到的最远位置，当我们达到的那个最大位置
            // 也就是 currentMaxIndex 的位置，就代表我们在这中间肯定需要跳一次
            // 找出中间能达到的最远置为 currentMaxIndex
            int currentMaxIndex = nums[0];
            int preMaxIndex = nums[0];
            int jumpMin = 1;
            for(int i = 1; i < nums.length; i++){
                if(i > currentMaxIndex){
                    jumpMin++;
                    currentMaxIndex = preMaxIndex;
                }
                if(preMaxIndex < nums[i] + i){
                    preMaxIndex = nums[i] + i;
                }
            }
            return jumpMin;
        }
    }
}
