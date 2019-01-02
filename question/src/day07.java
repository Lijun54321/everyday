import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Class day07 ...
 *
 * @author LiJun
 * Created on 2018/12/22
 */
public class day07 {
    public static void print(Node head) {
        if (head != null) {
            if (head.next != null) {
                print(head.next);
            }
            System.out.print(head.data + " ");
        }
    }

    public static void main(String[] args) {
        Node<Integer> test = null;
        Node<Integer> head = new Node<>(0);
        head = head.addInHead(1);
        head = head.addInHead(2);
        head = head.addInHead(3);
        head = head.addInHead(4);
        head = head.addInHead(5);
        head = head.addInHead(6);
        print(head);

        LinkedList linkedList = new LinkedList();
        linkedList.removeFirst();
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    // 剑指offer
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        sum(arrayList, listNode);
        return arrayList;

    }

    private void sum(ArrayList<Integer> arrayList, ListNode listNode) {
        if (listNode != null) {
            if (listNode.next != null) {
                sum(arrayList, listNode.next);
            }
            arrayList.add(listNode.val);
        }

    }
}
