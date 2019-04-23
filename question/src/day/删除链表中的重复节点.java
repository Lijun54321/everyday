package day;

import day.data.ListNode;

/**
 * Class 删除链表中的重复节点 ...
 *
 * @author LiJun
 * Created on 2019/4/16
 */
public class 删除链表中的重复节点 {
    public static class Solution {
        public ListNode deleteDuplication(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            // 新建一个节点，免得头结点会被删除的状态
            ListNode newHead = new ListNode(-1);
            newHead.next = head;
            ListNode p = head;
            ListNode pre = newHead;
            pre.next = head;

            while (p != null && p.next != null) {
                ListNode next = p.next;
                // 如果当前节点的值和下一个节点的值相等
                if (p.next.val == p.val) {
                    // 向后重复查找
                    while (next != null && p.val == next.val){
                        next = next.next;
                    }
                    pre.next = next;
                    p = next;
                } else {
                    pre = p;
                    p = p.next;
                }
            }
            return newHead.next;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {5, 4, 4, 3, 3, 2, 1};
        int[] array2 = {1,1};
        ListNode head = ListNode.getInstance(array2);
         ListNode.print(head);
        head = solution.deleteDuplication(head);
        ListNode.print(head);
    }

}
