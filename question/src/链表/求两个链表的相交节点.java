package 链表;

import data.ListNode;

import java.util.HashSet;

/**
 * Class 求两个链表的相交节点 ...
 *
 * @author LiJun
 * Created on 2019/4/23
 */
public class 求两个链表的相交节点 {
    private static class Solution {
        /**
         * 利用set做
         *
         * @param headA
         * @param headB
         * @return
         */
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            HashSet<ListNode> set = new HashSet<>();
            while (headA != null) {
                set.add(headA);
                headA = headA.next;
            }
            while (headB != null) {
                if (set.contains(headB)) {
                    return headB;
                }
                headB = headB.next;
            }
            return null;
        }

        /**
         * 时间复杂度O(n) 空间复杂度 O(1)
         *
         * @param headA
         * @param headB
         * @return
         */
        public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
            int lengthA = getLength(headA);
            int lengthB = getLength(headB);
            if (lengthA > lengthB) {
                headA = listForward(headA, lengthA - lengthB);
            }
            if (lengthA < lengthB) {
                headB = listForward(headB, lengthB - lengthA);
            }
            while (headA != null && headB != null) {
                if (headA == headB) {
                    return headA;
                }
                headA = headA.next;
                headB = headB.next;
            }
            return null;
        }

        private ListNode listForward(ListNode head, int i) {
            while (i != 0 && head != null) {
                head = head.next;
                i--;
            }
            return head;
        }

        public int getLength(ListNode p) {
            int count = 0;
            while (p != null) {
                p = p.next;
                count++;
            }
            return count;
        }
    }
}
