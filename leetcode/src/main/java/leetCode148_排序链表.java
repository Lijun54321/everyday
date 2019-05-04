import data.ListNode;

/**
 * Class leetCode148_排序链表 ...
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 * <p>
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 * @author LiJun
 * Created on 2019/4/27
 */
public class leetCode148_排序链表 {
    static class Solution {
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode mid = getMid(head);
            ListNode right = mid.next;
            mid.next = null;
            return mergeList(sortList(head), sortList(right));
        }

        private ListNode mergeList(ListNode head1, ListNode head2) {
            ListNode newHead = new ListNode(0);
            ListNode p = newHead;
            while (head1 != null && head2 != null) {
                if (head1.val < head2.val) {
                    p.next = head2;
                    p = p.next;
                    head2 = head2.next;
                } else {
                    p.next = head1;
                    head1 = head1.next;
                    p = p.next;
                }
            }
            if (head1 != null) {
                p.next = head1;
            }
            if (head2 != null) {
                p.next = head2;
            }
            return newHead.next;
        }

        private ListNode getMid(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {4, 3};
        ListNode head = ListNode.getInstance(array);
        ListNode.print(solution.sortList(head));
    }
}
