package day;

import day.data.ListNode;

import java.util.Comparator;
import java.util.LinkedList;

/**
 * Class 合并k个链表 ...
 *
 * @author LiJun
 * Created on 2019/4/23
 */
public class 合并k个链表 {
    static class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            LinkedList<ListNode> total = new LinkedList<>();
            for (ListNode p : lists) {
                while (p != null) {
                    total.add(p);
                    p = p.next;
                }
            }
            if (total.size() <= 0) {
                return null;
            }
            total.sort(Comparator.comparingInt(o -> o.val));

            ListNode head = total.get(0);
            ListNode p = head;
            for (int i = 1; i < total.size(); i++) {
                p.next = total.get(i);
                p = p.next;
            }
            p.next = null;
            return head;
        }

        public ListNode mergeKLists1(ListNode[] lists) {
            if (lists == null || lists.length <= 0) {
                return null;
            }
            if (lists.length == 1) {
                return lists[0];
            }
            if (lists.length == 2) {
                return mergeTwoLists(lists[0], lists[1]);
            }
            int mid = lists.length / 2;
            ListNode[] l1 = new ListNode[mid];
            for (int i = 0; i < mid; i++) {
                l1[i] = lists[i];
            }
            ListNode[] l2 = new ListNode[lists.length - mid];
            for (int i = mid, j = 0; i < lists.length; i++, j++) {
                l2[j] = lists[i];
            }
            return mergeTwoLists(mergeKLists(l1), mergeKLists(l2));
        }

        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode head = new ListNode(0);
            ListNode p = head;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    p.next = l1;
                    l1 = l1.next;
                } else {
                    p.next = l2;
                    l2 = l2.next;
                }
                p = p.next;
            }
            if (l1 != null) {
                p.next = l1;
            }
            if (l2 != null) {
                p.next = l2;
            }
            return head.next;
        }
    }

}
