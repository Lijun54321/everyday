package com;

import com.data.ListNode;

/**
 * Class leetCode2_add_two_numbers ...
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，
 * 它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * @author LiJun
 * Created on 2019/4/23
 */
public class leetCode2_add_two_numbers {
    class Solution {
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
}
