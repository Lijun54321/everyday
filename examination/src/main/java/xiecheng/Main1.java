package xiecheng;

import java.util.*;

/**
 * Class Main1 ...
 * 给定一个链表判断是不是含有环
 * @author LiJun
 * Created on 2019/4/8
 */
public class Main1 {
    static class ListNode{
        String val;
        ListNode next;

        public ListNode(String val) {
            this.val = val;
            this.next = null;
        }
    }

    /**
     * 这道题有问题，你给我们数据是根据节点来判断的，
     * 直接数组判重就可以了，如果我们根据你输入的数据，
     * 构造的话，我写一个构造吧
     *
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String[] strings = string.split(",");
        LinkedList<ListNode> list = new LinkedList<>();
        HashMap<String, ListNode> hashMap = new HashMap<>();

        // 先拿map来存所有的节点，之后拿map中的节点构造链表
        for(String s: strings){
            if(!hashMap.containsKey(s)){
                hashMap.put(s, new ListNode(s));
            }
        }
        // 构造链表
        ListNode head = hashMap.get(strings[0]);
        ListNode p = head;
        for(int i = 1; i < strings.length; i++){
            p.next = hashMap.get(strings[i]);
            p = p.next;
        }
        System.out.println(hasCycle(head));
    }

    /**
     * 这里拿数组处理，不做运行
     */
    public static boolean hasCycle(){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strings = str.split(",");
        Set<String> set = new LinkedHashSet<>();
        for(String s: strings){
            if(!set.add(s)){
                return false;
            }
        }
        return true;
    }
}
