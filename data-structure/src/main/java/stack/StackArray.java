package stack;

/**
 * Class StackArray ...
 *
 * @author LiJun
 * Created on 2019/4/12
 */
public class StackArray {
    private class Stack {
        int maxSize;
        int[] data;
        int top;

        private Stack(int maxSize) {
            this.maxSize = maxSize;
            this.data = new int[maxSize];
            this.top = -1;
        }
    }

    private Stack stack;
    private final int DEFAULT_MAXSIZE = 10;

    public StackArray() {
        this.stack = new Stack(DEFAULT_MAXSIZE);
    }

    public StackArray(int maxSize) {
        this.stack = new Stack(maxSize);
    }

    public boolean empty() {
        return stack.top == -1;
    }

    public boolean full() {
        return stack.top == stack.maxSize - 1;
    }

    public boolean push(int value) {
        if (!full()) {
            stack.data[++stack.top] = value;
            return true;
        }
        return false;
    }

    public int pop() {
        if (!empty()) {
            return stack.data[stack.top--];
        }
        // 最小值代表栈空
        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        StackArray stackArray = new StackArray();
        for(int i = 1; i < 12; i++){
            System.out.print(stackArray.push(i) + " ");
        }
        System.out.println();
        for(int i = 1; i < 12; i++){
            System.out.print(stackArray.pop() + " ");
        }
    }
}
