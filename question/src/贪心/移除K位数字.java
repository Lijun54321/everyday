package 贪心;

import java.util.Stack;

/**
 * Class 移除K位数字 ...
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 * <p>
 * 注意:
 * <p>
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 * 示例 1 :
 * <p>
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * 示例 2 :
 * <p>
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 示例 3 :
 * <p>
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 *
 * @author LiJun
 * Created on 2019/4/27
 */
public class 移除K位数字 {

    static class Solution {
        public String removeKdigits(String num, int k) {
            if (k <= 0) {
                return num;
            }
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < num.length(); i++) {
                int c = num.charAt(i) - '0';
                while(stack.size() != 0 && stack.peek() > c && k > 0){
                    stack.pop();
                    k--;
                }
                if(c != 0 || stack.size() != 0){
                    stack.push(c);
                }
            }
            while (!stack.isEmpty() && k != 0) {
                stack.pop();
                k--;
            }
            StringBuilder str = new StringBuilder();
            while (!stack.isEmpty()) {
                str.insert(0, stack.pop());
            }
            if (str.length() == 0) {
                return "0";
            }
            return str.toString();
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeKdigits("1432219", 3));
        System.out.println(solution.removeKdigits("100200", 1));
    }
}
