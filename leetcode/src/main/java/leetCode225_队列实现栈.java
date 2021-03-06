import java.util.LinkedList;
import java.util.Queue;

/**
 * Class leetCode225_队列实现栈 ...
 * 队列实现栈
 * @author LiJun
 * Created on 2019/4/24
 */
public class leetCode225_队列实现栈 {

    class MyStack {
        Queue<Integer> queue;

        /**
         * Initialize your data structure here.
         */
        public MyStack() {
            queue = new LinkedList<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            int n = queue.size();
            queue.offer(x);
            for (int i = 0; i < n; i++) {
                queue.offer(queue.poll());
            }
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            return queue.isEmpty() ? 0 :queue.poll();
        }

        /**
         * Get the top element.
         */
        public int top() {
            return queue.isEmpty() ? 0 : queue.peek();
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return queue.isEmpty();
        }
    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

}
