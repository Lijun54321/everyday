import data.ListNode;

/**
 * Class leetCode206_反转链表 ...
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * @author LiJun
 * Created on 2019/4/23
 */
public class leetCode206_反转链表 {
    class Solution {
        public ListNode reverseList(ListNode head) {
            if(head == null || head.next == null){
                return head;
            }
            ListNode newHead = head;
            ListNode p = head.next;
            newHead.next = null;
            while(p != null){
                ListNode temp = p.next;
                p.next = newHead;
                newHead = p;
                p = temp;
            }
            return newHead;
        }
    }
}
