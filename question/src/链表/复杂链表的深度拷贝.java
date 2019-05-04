package 链表;

import java.util.HashMap;
import java.util.Map;

/**
 * Class 复杂链表的深度拷贝 ...
 * Class leetCode138_copy_list_with_random_pointer ...
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 * <p>
 * 要求返回这个链表的深拷贝。
 * 示例：
 * 输入：
 * {"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}
 * <p>
 * 解释：
 * 节点 1 的值是 1，它的下一个指针和随机指针都指向节点 2 。
 * 节点 2 的值是 2，它的下一个指针指向 null，随机指针指向它自己
 *
 * @author LiJun
 * Created on 2019/4/23
 * @author LiJun
 * Created on 2019/4/23
 */
public class 复杂链表的深度拷贝 {

    // Definition for a data.Node.
    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    class Solution {
        public Node copyRandomList(Node head) {
            Map<Node, Node> map = new HashMap<>();
            Node cur = head;
            while (cur != null) {
                Node copy = new Node(cur.val, null, null);
                map.put(cur, copy);
                cur = cur.next;
            }
            cur = head;
            while (cur != null) {
                Node copy = map.get(cur);
                copy.next = map.get(cur.next);
                copy.random = map.get(cur.random);
                cur = cur.next;
            }

            return map.get(head);
        }
    }
}
