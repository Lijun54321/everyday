package day;

import java.util.Stack;

/**
 * Class 栈的压入_弹出序列 ...
 * 输入两个整数序列，第一个序列表示栈的压入顺序，
 * 请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 *
 * @author LiJun
 * Created on 2019/4/15
 */
public class 栈的压入_弹出序列 {
    public static class Solution {
        public boolean IsPopOrder(int[] pushA, int[] popA) {
            // 参数有效性检测
            if (pushA == null || popA == null
                    || pushA.length <= 0 || popA.length <= 0
                    || pushA.length!=popA.length) {
                return false;
            }
            // 借助一个辅助队列，将push的进行压栈
            Stack<Integer> stack = new Stack<>();
            int t = 0;
            for (int i = 0; i < pushA.length; i++) {
                stack.push(pushA[i]);
                while (!stack.empty() &&
                        t < pushA.length &&
                        popA[t] == stack.peek()) {
                    stack.pop();
                    t++;
                }
            }
            return stack.size() == 0;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] push = new int[]{1, 2, 3, 4, 5};
        int[] popA = new int[]{4, 5, 3, 2, 1};
        int[] popB = new int[]{4, 3, 5, 1, 2};
        System.out.println(solution.IsPopOrder(push, popA));
        System.out.println(solution.IsPopOrder(push, popB));
    }
}
