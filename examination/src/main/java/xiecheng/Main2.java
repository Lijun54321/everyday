package xiecheng;

import java.util.Scanner;

/**
 * Class Main2 ...
 *
 * @author LiJun
 * Created on 2019/4/8
 */
public class Main2 {
    static class ListNode {
        String val;
        ListNode next;

        public ListNode(String val) {
            this.val = val;
            this.next = null;
        }
    }

    public static ListNode reverseKGroup(ListNode node, int k) {
        if (node == null || node.next == null) {
            return node;
        }
        int count = 0;
        ListNode temp = new ListNode("0");
        temp.next = node;
        ListNode pre = temp;
        ListNode cur = node;
        while (cur != null) {
            ListNode next = cur.next;
            count++;
            if (count == k) {
                pre = reverse(pre, next);
                count = 0;
            }
            cur = next;
        }
        return temp.next;
    }
    public static ListNode reverse(ListNode pre, ListNode end) {
        if (pre == null || pre.next == null) {
            return pre;
        }
        ListNode head = pre.next;
        ListNode cur = pre.next.next;
        while (cur != end) {
            ListNode next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
        }
        head.next = end;
        return head;
    }

    public static ListNode create(ListNode head, String s) {
        if (head == null) return new ListNode(s);
        ListNode p = head;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new ListNode(s);
        return head;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        int k = scanner.nextInt();
        string = string.replace("[", "");
        string = string.replace("]", "");
        String[] strings = string.split(",");
        ListNode head = null;
        ListNode temp = null;
        for (String s : strings) {
            if(head == null){
                head = new ListNode(s);
                temp = head;
            }else{
                temp.next = new ListNode(s);
                temp = temp.next;
            }
        }
        print(head);

        head = reverseKGroup(head, k);
        print(head);
    }

    private static void print(ListNode head) {
        System.out.print("[");
        ListNode p = head;
        for (p = head; p.next != null; p = p.next)
            System.out.print(p.val + ",");
        if (p != null) System.out.println(p.val + "]");
        else System.out.println("]");
    }


}
