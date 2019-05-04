package data;

import java.util.ArrayList;
import java.util.List;

/**
 * Class day.data.Node ...
 *
 * @author LiJun
 * Created on 2018/12/22
 */
public class Node<T> {
    /**
     * 假设我们的链表有头结点
     */
    public T data;
    public Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    public Node<T> addInTail(T data) {
        Node<T> node = new Node<>(data);
        if (this == null) {
            return node;
        }
        Node<T> p = this;
        while (p.next != null) {
            p = p.next;
        }
        p.next = node;
        return this;
    }


    public Node<T> addInHead(T data) {
        Node<T> node = new Node<>(data);
        node.next = this;
        return node;
    }


    public Node<T> delete(int index) {
        Node<T> p = this;
        if (index == 1) {
            return this.next;
        }
        int i = 0;
        while (p.next != null) {
            if (index - 1 == i++) {
                // 删除操作
                p.next = p.next.next;
            }
            p = p.next;
        }
        return this;
    }


    public T select(int index) {
        Node<T> p = this;
        while (index-- > 1 && p != null) {
            p = p.next;
        }
        if (p == null) {
            return null;
        }
        return p.data;
    }


    public void update(int index, T data) {
        Node<T> p = this;
        while (index-- > 1 && p != null) {
            p = p.next;
        }
        if (p != null) {
            p.data = data;
        }
    }

    @Override
    public String toString() {
        List<T> list = new ArrayList<>();
        Node<T> p = this;
        while (p != null) {
            list.add(p.data);
            p = p.next;
        }

        return "data.Node{" + list + '}';
    }


    public static void main(String[] args) {
        Node<Integer> head = new Node<Integer>(0);
        head = head.addInHead(1);
        head = head.addInTail(2);
        head = head.addInHead(3);
        head = head.addInTail(4);
        System.out.println(head);
        head = head.delete(1);
        System.out.println(head);

        System.out.println(head.select(2));
        head.update(1, 6);
        System.out.println(head);
    }
}
