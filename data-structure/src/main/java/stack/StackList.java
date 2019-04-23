package stack;

/**
 * Class StackList ...
 *
 * @author LiJun
 * Created on 2019/4/12
 */
public class StackList {
    private class StackNode {
        int data;
        StackNode next;

        private StackNode(int data, StackNode next) {
            this.data = data;
            this.next = next;
        }
    }

    private class LinkStack {
        StackNode top;
        int count;
    }

    private LinkStack stack;

    public StackList() {
        this.stack = new LinkStack();
    }

    public boolean push(int data) {
        stack.top = new StackNode(data, stack.top);
        stack.count++;
        return true;
    }

    public boolean empty() {
        return stack.top == null;
    }

    public int pop() {
        if (!empty()) {
            int data = stack.top.data;
            stack.count--;
            stack.top = stack.top.next;
            return data;
        }
        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        StackList stackList = new StackList();
        for (int i = 0; i < 11; i++) {
            stackList.push(i);
        }
        System.out.println();
        for (int i = 0; i < 12; i++) {
            System.out.print(stackList.pop() + " ");
        }
    }

}
