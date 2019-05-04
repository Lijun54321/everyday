import java.util.Stack;

/**
 * Class leetCode232_栈实现队列 ...
 * 两栈实现一个队列
 * @author LiJun
 * Created on 2019/4/24
 */
public class leetCode232_栈实现队列 {


    class MyQueue {
        Stack<Integer> stack1;
        Stack<Integer> stack2;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            stack1.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.isEmpty() ? 0 : stack2.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.isEmpty() ? 0 : stack2.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            if (stack2.isEmpty() && stack1.isEmpty()) {
                return true;
            }
            return false;
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}
