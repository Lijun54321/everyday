package com;

import com.data.ListNode;

/**
 * Class leetCode160_intersection_of_two_linked_lists ...
 * 编写一个程序，找到两个单链表相交的起始节点。
 * @author LiJun
 * Created on 2019/4/23
 */
public class leetCode160_intersection_of_two_linked_lists {
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
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
