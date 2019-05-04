package 链表;

import data.ListNode;

/**
 * Class day24_两数相加_链表 ...
 *
 * @author LiJun
 * Created on 2019/4/8
 */
public class day24_两数相加_链表 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode head, p = head = new ListNode(-1);
            int flag = 0;
            while (l1 != null && l2 != null) {
                p.next = l1;
                p = p.next;
                int t = l1.val;
                p.val = (l1.val + l2.val + flag) % 10;
                flag = (t + l2.val + flag) / 10;
                l1 = l1.next;
                l2 = l2.next;
            }
            while (l1 != null) {
                p.next = l1;
                p = p.next;
                int t = l1.val;
                p.val = (t + flag) % 10;
                flag = (t + flag) / 10;
                l1 = l1.next;
            }
            while (l2 != null) {
                p.next = l2;
                p = p.next;
                int t = l2.val;
                p.val = (l2.val + flag) % 10;
                flag = (t + flag) / 10;
                l2 = l2.next;
            }
            if (flag == 1) {
                p.next = new ListNode(1);
            }
            return head.next;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(8);
        // l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(1);
        // l2.next = new ListNode(6);
        // l2.next.next = new ListNode(4);
        ListNode.print(solution.addTwoNumbers(l2, l1));
    }
}
