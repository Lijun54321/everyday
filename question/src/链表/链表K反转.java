package 链表;

import data.ListNode;

/**
 * Class 链表K反转 ...
 *
 * @author LiJun
 * Created on 2019/4/23
 */
public class 链表K反转 {
    private static class Solution {
        /**
         * 以k为值，反转链表，不足k也反转
         *
         * @param head
         * @param k
         * @return
         */
        ListNode reverseK(ListNode head, int k) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode p = head;
            ListNode newHead = null;
            int count = 0;
            while (count < k && p != null) {
                ListNode temp = p.next;
                p.next = newHead;
                newHead = p;
                p = temp;
                count++;
            }
            if (p != null) {
                head.next = reverseK(p, k);
            }
            return newHead;
        }

        /**
         * 以k为值，反转链表，不足k不反转
         * @param head
         * @param k
         * @return
         */
        ListNode reverseKGroup(ListNode head, int k) {
            if (head == null || head.next == null || getLength(head) < k) {
                return head;
            }
            ListNode p = head;
            ListNode newHead = null;
            int count = 0;
            while (count < k && p != null) {
                ListNode temp = p.next;
                p.next = newHead;
                newHead = p;
                p = temp;
                count++;
            }
            if (p != null) {
                head.next = reverseKGroup(p, k);
            }
            return newHead;
        }

        int getLength(ListNode p) {
            int count = 0;
            while (p != null) {
                count++;
                p = p.next;
            }
            return count;
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        ListNode head = ListNode.getInstance(array);
        ListNode.print(head);
        ListNode.print(solution.reverseK(head, 4));
        ListNode head2 = ListNode.getInstance(array);
        ListNode.print(head2);
        ListNode.print(solution.reverseKGroup(head2, 4));
    }
}
