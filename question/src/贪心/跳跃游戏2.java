package 贪心;

/**
 * Class 跳跃游戏2 ...
 *
 * @author LiJun
 * Created on 2019/4/27
 */
public class 跳跃游戏2 {

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
