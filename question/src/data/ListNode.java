package data;

/**
 * Class ListNode ...
 *
 * @author LiJun
 * Created on 2019/4/8
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

    public static ListNode createNode1() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        // head.next.next.next.next.next.next.next = new ListNode(8);
        // head.next.next.next.next.next.next.next.next = new ListNode(9);
        return head;
    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static ListNode getInstance(int[] array) {
        ListNode root = null;
        for (int i : array) {
            ListNode p = new ListNode(i);
            p.next = root;
            root = p;
        }
        return root;
    }

}