package 栈和队列;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Class 后缀表达式 ...
 *
 * @author LiJun
 * Created on 2019/4/24
 */
public class 后缀表达式 {
    private static int getSize(char s) {
        // 如果是 * 和 / 说明他们级别高
        if ('*' == s || s == '/') {
            return 1;
        } else if ('-' == s || '+' == s) {
            // 如果是- 和 +  级别低
            return 0;
        }
        // 这里主要是处理其余的符号 比如 ( 之类的
        return -1;
    }

    private static List<String> parseSuffixExpression(String s) {
        s = getNormal(s);
        if (s == null) {
            return null;
        }
        LinkedList<String> result = new LinkedList<>();
        Stack<Character> opertion = new Stack<>();
        for (int i = 0; i < s.length(); i++) {

            if (isNum(s.charAt(i))) {
                int num = 0;
                while (i < s.length() && isNum(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                result.add(num + "");
                --i;
            } else if (s.charAt(i) == '(') {
                opertion.push('(');
            } else if (s.charAt(i) == ')') {
                while (!opertion.isEmpty() && opertion.peek() != '(') {
                    result.add(opertion.pop() + "");
                }
                // 把左括号出栈
                if (!opertion.isEmpty()) {
                    opertion.pop();
                }
            } else {
                if (opertion.isEmpty()) {
                    opertion.push(s.charAt(i));
                } else {
                    if (getSize(s.charAt(i)) == 1) {
                        while (!opertion.isEmpty() && getSize(opertion.peek()) == 1) {
                            result.add(opertion.pop() + "");
                        }
                        opertion.push(s.charAt(i));
                    } else {
                        while (!opertion.isEmpty() && opertion.peek() != '(') {
                            result.add(opertion.pop() + "");
                        }
                        opertion.push(s.charAt(i));

                    }
                }
            }
        }
        while (!opertion.isEmpty()) {
            result.add(opertion.pop() + "");
        }
        return result;
    }

    private static boolean isNum(char c) {
        return c <= '9' && c >= '0';
    }

    /**
     * 处理一些特殊的字符
     *
     * @param str 字符串
     * @return 处理结果
     */
    private static String getNormal(String str) {
        if (str == null) {
            return null;
        }
        // 去掉空格
        str = str.replace(" ", "");
        // 处理中文字符
        str = str.replace("（", "(");
        str = str.replace("）", ")");
        str = str.replace("X", "*");
        str = str.replace("x", "*");
        return str;
    }

    private static int getResult(List<String> str) {
        Stack<Integer> stack = new Stack<>();
        for (String s : str) {
            if ("*".equals(s)) {
                if (stack.size() < 1) {
                    return 0;
                }
                int m = stack.pop();
                int n = stack.pop();
                stack.push(m * n);
            } else if ("+".equals(s)) {
                if (stack.size() < 1) {
                    return 0;
                }
                int m = stack.pop();
                int n = stack.pop();
                stack.push(m + n);
            } else if ("-".equals(s)) {
                if (stack.size() < 1) {
                    return 0;
                }
                int m = stack.pop();
                int n = stack.pop();
                stack.push(n - m);
            } else if ("/".equals(s)) {
                if (stack.size() < 1) {
                    return 0;
                }
                int m = stack.pop();
                if (m == 0) {
                    return 0;
                }
                int n = stack.pop();
                stack.push(n / m);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        String s = "9+(3-1)X3+10/2";
        List<String> strings = parseSuffixExpression("14/3*2");
        System.out.println(strings);
        System.out.println(getResult(strings));
        // System.out.println(getResult(strings));
    }
}
