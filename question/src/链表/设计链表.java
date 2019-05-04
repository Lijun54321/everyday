package 链表;

/**
 * Class 设计链表 ...
 *
 * @author LiJun
 * Created on 2019/4/27
 */
public class 设计链表 {
    class MyLinkedList {

        class Node {
            int val;
            Node next;

            Node(int val) {
                this.val = val;
            }
        }

        int size = 0;
        private Node head = new Node(0);

        private Node tail = head;


        public MyLinkedList() {

        }

        public int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }
            Node curr = head;
            while (index >= 0) {
                index--;
                curr = curr.next;
            }
            return curr.val;
        }

        public void addAtHead(int val) {
            size++;
            Node node = new Node(val);
            node.next = head.next;
            head.next = node;
            if (tail == head) {
                tail = node;
            }
        }

        public void addAtTail(int val) {
            size++;
            Node node = new Node(val);
            tail.next = node;
            tail = tail.next;
        }

        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }
            size++;
            Node node = new Node(val);
            if (index == size - 1) {
                tail.next = node;
                tail = tail.next;
                return;
            }

            Node curr = head;
            // 找到前一个
            while (index > 0) {
                index--;
                curr = curr.next;
            }
            node.next = curr.next;
            curr.next = node;
        }


        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            size--;
            Node curr = head;
            // 找到被删的前一个
            while (index > 0) {
                index--;
                curr = curr.next;
            }
            if (curr.next != null) {
                curr.next = curr.next.next;
            }
            if (curr.next == null) {
                tail = curr;
            }

        }
    }
}
