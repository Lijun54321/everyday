package 递归回溯分治;

import data.ListNode;

import java.util.Stack;

/**
 * Class 递归逆序一个链表 ...
 *
 * @author LiJun
 * Created on 2019/4/30
 */
public class 递归逆序一个链表 {
    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nowHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return nowHead;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.createNode1();
        ListNode.print(head);
/*        head = reverse(head);
        ListNode.print(head);*/
        push(head);
        ListNode.print(reverse(head));
    }

    public static void push(ListNode head) {

        Stack<Integer> stack = new Stack<>();
        push(head, stack);
        System.out.println(stack);
    }

    private static void push(ListNode head, Stack<Integer> stack) {
        if (head == null) {
            return;
        }
        push(head.next, stack);
        stack.push(head.val);
    }
}
