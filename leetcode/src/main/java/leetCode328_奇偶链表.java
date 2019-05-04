import data.ListNode;

/**
 * Class leetCode328_奇偶链表 ...
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。
 * 请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 *
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * 说明:
 *
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 *
 * @author LiJun
 * Created on 2019/4/23
 */
public class leetCode328_奇偶链表 {
    class Solution {
        public ListNode oddEvenList(ListNode head) {
            if (head == null || head.next == null || head.next.next == null) {
                return head;
            }
            ListNode p1 = head;
            ListNode p2 = head.next;
            ListNode p3 = head.next.next;
            ListNode node2 = head.next;
            while (true) {
                p2.next = p3.next;
                p2 = p2.next;
                p3.next = node2;
                p1.next = p3;
                p1 = p1.next;
                if (p2 != null && p2.next != null) {
                    p3 = p2.next;
                } else {
                    break;
                }
            }

            return head;
        }

    }
}
