import java.util.Stack;

/**
 * Class leetCode224_基本计算器 ...
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 *
 * 字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格  。
 *
 * 示例 1:
 *
 * 输入: "1 + 1"
 * 输出: 2
 * 示例 2:
 *
 * 输入: " 2-1 + 2 "
 * 输出: 3
 * 示例 3:
 *
 * 输入: "(1+(4+5+2)-3)+(6+8)"
 * 输出: 23
 *
 * @author LiJun
 * Created on 2019/4/24
 */
public class leetCode224_基本计算器 {
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
