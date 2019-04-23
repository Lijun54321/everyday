package stack;

import java.util.Stack;

/**
 * Class DoubleStack ...
 * 两栈实现队列
 *
 * @author LiJun
 * Created on 2019/4/12
 */
public class DoubleStack {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() throws Exception {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.empty()) {
            throw new Exception("Queue is empty!");
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        DoubleStack doubleStack = new DoubleStack();
        for (int i = 0; i < 10; i++) {
            doubleStack.push(i);
        }
        for (int i = 0; i < 11; i++) {
            try {
                System.out.print(doubleStack.pop() + " ");
            } catch (Exception e) {
                System.out.println();
                e.printStackTrace();
            }
        }
    }
}