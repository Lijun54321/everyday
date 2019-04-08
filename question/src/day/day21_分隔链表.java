package day;


import day.data.ListNode;

/**
 * Class day21_分隔链表 ...
 *
 * @author LiJun
 * Created on 2019/4/8
 */
public class day21_分隔链表 {
    private class Solution {
        private ListNode[] splitListToParts(ListNode root, int k) {
            ListNode[] lists = new ListNode[k];
            int len = 0;
            for (ListNode p = root; p != null; p = p.next) {
                len++;
            }
            int t = (int) Math.ceil((double) len / k);
            int m = len % k;
            for (int i = 0; i < k && root != null; i++) {
                lists[i] = root;
                for (int j = 1; j < (i < m ? t : m == 0 ? t : t - 1); j++) {
                    root = root.next;
                }
                ListNode temp = root.next;
                root.next = null;
                root = temp;
            }
            return lists;
        }

    }
}
