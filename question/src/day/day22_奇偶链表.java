package day;

import day.data.ListNode;

/**
 * Class day22_奇偶链表 ...
 *
 * @author LiJun
 * Created on 2019/4/8
 */
public class day22_奇偶链表 {
    private static class Solution{
        public ListNode oddEvenList(ListNode head) {
            if (head == null || head.next == null || head.next.next == null) {
                return head;
            }
            ListNode p1 = head;
            ListNode p2 = head.next;
            ListNode p3 = head.next.next;
            ListNode node2 = head.next;
            while (true) {
                p2.next = p3.next;
                p2 = p2.next;
                p3.next = node2;
                p1.next = p3;
                p1 = p1.next;
                if (p2 != null && p2.next != null) {
                    p3 = p2.next;
                } else {
                    break;
                }
            }
            return head;
        }

        public static void main(String[] args) {
            ListNode head = ListNode.createNode1();
            System.out.print(head);
        }
    }
}
