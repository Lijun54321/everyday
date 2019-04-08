package day;

import java.util.Stack;

/**
 * Class day.day11_两栈实现队列 ...
 *
 * @author LiJun
 * Created on 2018/12/26
 */
public class day11_两栈实现队列 {

    public static class Queue<T> {
        private Stack<T> stack1 = new Stack<>();
        private Stack<T> stack2 = new Stack<>();

        public void appendTail(T data) {
            stack1.push(data);
        }


        public T deleteHead() {
            if (stack2.empty()) {
                while (!stack1.empty()) {
                    stack2.push(stack1.pop());
                }
            }
            if (stack2.empty()) {
                return null;
            }
            return stack2.pop();
        }

        @Override
        public String toString() {
            return "\nQueue{" +
                    "stack1=" + stack1 +
                    ", stack2=" + stack2 +
                    '}';
        }
    }


    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        // 依次向队列插入 1 2 3 4 数据 并打印当前队列信息
        queue.appendTail(1);
        queue.appendTail(2);
        queue.appendTail(3);
        queue.appendTail(4);
        System.out.print(queue);
        // 移出并打印队列两个元素 打印队列
        System.out.print(queue.deleteHead() + " ");
        System.out.print(queue.deleteHead() + " ");
        System.out.print(queue);
        // 向队列append 元素 5 6  并打印队列
        queue.appendTail(5);
        queue.appendTail(6);
        System.out.print(queue);
        // 移除队列
        System.out.print(queue.deleteHead() + " ");
        System.out.print(queue.deleteHead() + " ");
        System.out.print(queue.deleteHead() + " ");
        System.out.print(queue.deleteHead() + " ");
        System.out.println(queue);
        System.out.print(queue.deleteHead() + " ");
        System.out.print(queue.deleteHead() + " ");
        System.out.print(queue);
        System.out.print(queue);
    }
}
