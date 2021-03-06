package 链表;

import data.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Class 链表组件 ...
 * 给定一个链表（链表结点包含一个整型值）的头结点 head。
 *
 * 同时给定列表 G，该列表是上述链表中整型值的一个子集。
 *
 * 返回列表 G 中组件的个数，这里对组件的定义为：链表中一段最长连续结点的值（
 * 该值必须在列表 G 中）构成的集合。
 *
 * 示例 1：
 *
 * 输入:
 * head: 0->1->2->3
 * G = [0, 1, 3]
 * 输出: 2
 * 解释:
 * 链表中,0 和 1 是相连接的，且 G 中不包含 2，
 * 所以 [0, 1] 是 G 的一个组件，同理 [3] 也是一个组件，故返回 2。
 * 示例 2：
 *
 * 输入:
 * head: 0->1->2->3->4
 * G = [0, 3, 1, 4]
 * 输出: 2
 * 解释:
 * 链表中，0 和 1 是相连接的，3 和 4 是相连接的，所以 [0, 1] 和 [3, 4] 是两个组件，故返回 2。
 * @author LiJun
 * Created on 2019/4/27
 */
public class 链表组件 {
    class Solution {
        public int numComponents(ListNode head, int[] G) {
            Set<Integer> set = new HashSet<>();
            for (int num : G) {
                set.add(num);
            }
            int count = 0;
            ListNode pre = head;
            while (head != null) {
                if (set.contains(pre.val) && !set.contains(head.val)) {
                    count++;
                }
                pre = head;
                head = head.next;
            }
            if (set.contains(pre.val)) {
                count++;
            }
            return count;
        }
    }
}
