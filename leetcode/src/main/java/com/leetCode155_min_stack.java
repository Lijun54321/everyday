package com;

import java.util.Stack;

/**
 * Class leetCode155_min_stack ...
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 * @author LiJun
 * Created on 2019/4/24
 */
public class leetCode155_min_stack {
    class MinStack {
        Stack<Integer> stack;
        Stack<Integer> min;
        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack<>();
            min = new Stack<>();

        }

        public void push(int x) {
            stack.push(x);
            if(min.isEmpty() || x <= min.peek()){
                min.push(x);
            }
        }

        public void pop() {
            if(min.peek().equals(stack.peek())){
                min.pop();
            }
            stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min.peek();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
