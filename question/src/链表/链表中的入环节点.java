package 链表;

import data.ListNode;

import java.util.HashSet;

/**
 * Class 链表中的入环节点 ...
 *
 * @author LiJun
 * Created on 2019/4/16
 */
public class 链表中的入环节点 {
    public class Solution {
        public ListNode EntryNodeOfLoop(ListNode head) {
            if(head == null || head.next == null){
                return null;
            }
            HashSet<ListNode> set = new HashSet<>();
            while(head != null){
                if(!set.add(head)){
                    return head;
                }
                head = head.next;
            }
            return null;
        }
    }

}
