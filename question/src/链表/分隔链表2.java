package 链表;

import data.ListNode;

/**
 * Class 分隔链表2 ...
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * <p>
 * 你应当保留两个分区中每个节点的初始相对位置。
 * <p>
 * 示例:
 * <p>
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 *
 * @author LiJun
 * Created on 2019/4/23
 */
public class 分隔链表2 {
    class Solution {
        /**
         * 思路是巧妙利用头指针 拆成两个链表,一个存 <x 的, 一个存 >=x的, 拆完后再拼起来
         * @param head
         * @param x
         * @return
         */
        public ListNode partition(ListNode head, int x) {
            ListNode lessHead = new ListNode(0);
            ListNode moreHead = new ListNode(1);
            ListNode p1 = lessHead;
            ListNode p2 = moreHead;
            while (head != null) {
                if (head.val < x) {
                    p1.next = head;
                    p1 = p1.next;
                } else {
                    p2.next = head;
                    p2 = p2.next;
                }
                head = head.next;
            }
            p1.next = moreHead.next;
            return lessHead.next;
        }
    }
}
