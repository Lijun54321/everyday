import data.ListNode;

import java.util.Comparator;
import java.util.LinkedList;

/**
 * Class leetCode23_合并k个有序链表 ...
 *
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 * @author LiJun
 * Created on 2019/5/1
 */
public class leetCode23_合并k个有序链表 {
    class Solution {
        public ListNode mergeKLists1(ListNode[] lists) {
            LinkedList<ListNode> total = new LinkedList<>();
            for(ListNode p : lists){
                while(p != null){
                    total.add(p);
                    p = p.next;
                }
            }
            if(total.size() <= 0){
                return null;
            }
            total.sort(Comparator.comparingInt(o -> o.val));
            ListNode head = total.get(0);
            ListNode p = head;
            for(int i = 1; i < total.size(); i++){
                p.next = total.get(i);
                p = p.next;
            }
            p.next = null;
            return head;
        }
        public ListNode mergeKLists(ListNode[] lists) {
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
