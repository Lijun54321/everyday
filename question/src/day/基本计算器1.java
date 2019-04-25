package day;

import java.util.Stack;

/**
 * Class 基本计算器1 ...
 *
 * @author LiJun
 * Created on 2019/4/24
 */
public class 基本计算器1 {
    static class Solution {
        public int calculate(String s) {
            if (s == null || s.length() <= 0) {
                return -1;
            }
            // 处理掉空格
            s = s.replace(" ", "");
            Stack<Integer> data = new Stack<>();
            int sign = 1;
            int res = 0;
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(isNum(c)){
                    int num = 0;
                    while(i < s.length() && isNum(s.charAt(i)) ){
                        num = num*10 + s.charAt(i++) - '0';
                    }
                    res += sign*num;
                    --i;
                }else if(c == '+'){
                    sign = 1;
                }else if(c == '-'){
                    sign = -1;
                }else if(c == '('){
                    data.push(res);
                    data.push(sign);
                    res = 0;
                    sign = 1;
                }else if(c == ')'){
                    res *= data.pop();
                    res += data.pop();
                }
            }
            return res;
        }

        private boolean isNum(char c) {
            return c <= '9' && c >= '0';
        }
    }

    public static void main(String[] args) {
        String s = "2-(5-6)";
        Solution solution = new Solution();
        System.out.println(solution.calculate("2-1+2"));
    }
}

