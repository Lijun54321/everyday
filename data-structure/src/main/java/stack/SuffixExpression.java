package stack;

import java.util.*;

/**
 * Class SuffixExpression ...
 *
 * @author LiJun
 * Created on 2019/4/12
 */
public class SuffixExpression {
    /**
     * 对比操作数大小的函数
     *
     * @param s 操作数
     * @return integer数
     */
    private int getSize(String s) {
        // 如果是 * 和 / 说明他们级别高
        if ("*".equals(s) || "/".equals(s)) {
            return 1;
        }// 如果是- 和 +  级别低
        else if ("-".equals(s) || "+".equals(s)) {
            return 0;
        }
        // 这里主要是处理其余的符号 比如 ( 之类的
        return -1;
    }

    /**
     * 把传进来的中序表达式转换成逆波兰表达式
     *
     * @return 转换后的逆波兰表达式
     */
    public List<String> parseSuffixExpression(String str) {
        if (str == null) {
            return null;
        }
        // 先进行格式化
        str = getNormal(str);
        // 用来处理结果的
        Stack<String> stack1 = new Stack<>();
        // 存操作数的
        Stack<String> stack2 = new Stack<>();
        assert str != null;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            // 如果是 ( 直接入栈
            if (chars[i] == '(') {
                stack2.push(chars[i] + "");
            } else if (chars[i] == ')') {
                // 如果是) 出栈到第一个 "("
                while (!stack2.empty() && !"(".equals(stack2.peek())) {
                    stack1.push(stack2.pop());
                }
                if (!stack2.empty()) {
                    stack2.pop();
                }
            } else if (chars[i] >= '0' && chars[i] <= '9') {
                // 如果是数字，向后走，找到所有数字
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(chars[i]);
                for (int j = i + 1; j < chars.length; j++) {
                    if (chars[j] < '0' || chars[j] > '9') {
                        i = j - 1;
                        break;
                    } else {
                        stringBuilder.append(chars[j]);
                    }
                }
                stack1.push(stringBuilder.toString());
            } else {
                // 如果是操作数，如果栈顶元素级别高，一直出栈2 入栈1
                while (!stack2.empty() && getSize(stack2.peek()) >= getSize(chars[i] + "")) {
                    stack1.push(stack2.pop());
                }
                stack2.push(chars[i] + "");
            }
        }
        // 如果栈2不空，全部移入栈1
        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
        // 反转一下结果 存入 list
        List<String> list = new LinkedList<>();
        while (!stack1.empty()) {
            list.add(0, stack1.pop());
        }
        return list;
    }

    /**
     * 计算逆波兰表达式的值
     *
     * @param str 逆波兰表达式
     * @return 结果
     */
    public int getResult(List<String> str) {
        Stack<Integer> stack = new Stack<>();
        for (String s : str) {
            if ("*".equals(s)) {
                stack.push(stack.pop() * stack.pop());
            } else if ("-".equals(s)) {
                stack.push(-stack.pop() + stack.pop());
            } else if ("+".equals(s)) {
                stack.push(stack.pop() + stack.pop());
            } else if ("/".equals(s)) {
                int one = stack.pop();
                int two = stack.pop();
                stack.push(two / one);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        if (stack.size() == 1) {
            return stack.pop();
        }
        return 0;
    }

    /**
     * 处理一些特殊的字符
     *
     * @param str 字符串
     * @return 处理结果
     */
    private String getNormal(String str) {
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

    public static void main(String[] args) {
        String string = "9+(3-1)*3+10/2";
        SuffixExpression expression = new SuffixExpression();
        List<String> list = expression.parseSuffixExpression(string);
        System.out.println(list);
        System.out.println(expression.getResult(list));

    }
}
