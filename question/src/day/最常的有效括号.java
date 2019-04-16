package day;

import java.util.Stack;

/**
 * Class 最常的有效括号 ...
 *
 * @author LiJun
 * Created on 2019/4/15
 */
public class 最常的有效括号 {
    class Solution {
        public int longestValidParentheses(String s) {
            char[] chars = s.toCharArray();
            return Math.max(calc(chars, 0, 1, chars.length, '('),
                    calc(chars, chars.length - 1, -1, -1, ')'));
        }

        private int calc(char[] chars, int start, int flag, int end, char cTem) {
            int max = 0, sum = 0, currLen = 0, validLen = 0;
            for (; start != end; start += flag) {
                sum += (chars[start] == cTem ? 1 : -1);
                currLen++;
                if (sum < 0) {
                    max = max > validLen ? max : validLen;
                    sum = 0;
                    currLen = 0;
                    validLen = 0;
                } else if (sum == 0) {
                    validLen = currLen;
                }
            }
            return max > validLen ? max : validLen;
        }
    }

    public int longestValidParentheses(String s) {
        int[] mark = new int[s.length() + 1];
        int ret = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //左括号则进栈
            if (c == '(') {
                stack.push(i);
            }
            //右括号
            else {
                //没有与之匹配的左括号，抛弃，继续向前
                if (stack.isEmpty()) {

                } else { //有左括号
                    mark[stack.pop()] = 1;
                    mark[i] = 1;
                }
            }
        }

        int leftIndex = -1;
        for (int i = 0; i < mark.length; i++) {
            //左侧开始
            if (leftIndex == -1 && mark[i] == 1) {
                leftIndex = i;
            }
            //右侧结束
            if (leftIndex != -1 && mark[i] == 0) {
                ret = Math.max(ret, i - leftIndex);
                leftIndex = -1;
            }
        }
        return ret;
    }
}