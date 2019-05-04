import data.ListNode;

/**
 * Class leetCode147_对链表进行插入排序 ...
 *
 * @author LiJun
 * Created on 2019/4/27
 */
public class leetCode147_对链表进行插入排序 {
    static class Solution {
        public ListNode insertionSortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode newHead = new ListNode(0);
            newHead.next = head;
            ListNode p = head.next;
            head.next = null;
            while (p != null) {
                ListNode t = newHead;
                while (t.next != null) {
                    if (t.next.val > p.val) {
                        break;
                    }
                    t = t.next;
                }
                ListNode temp = p.next;
                p.next = t.next;
                t.next = p;
                p = temp;
            }
            return newHead.next;
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {-1, 5, 3, 4, 0};

        ListNode head = ListNode.getInstance(array);
        ListNode.print(solution.insertionSortList(head));
    }
}
