import java.util.ArrayList;
import java.util.List;

/**
 * Class MyList ...
 *
 * @author LiJun
 * Created on 2018/12/22
 */
public class MyList<T> {
    public static class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;

        public Node(T item, Node<T> prev, Node<T> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    private int size = 0;
    private Node<T> first;
    private Node<T> last;

    public MyList() {
        first = last = null;
    }

    public void addFirst(T item) {
        final Node<T> f = first;
        final Node<T> newNode = new Node<>(item, null, first);
        first = newNode;
        if (f == null) {
            last = newNode;
        } else {
            f.prev = newNode;
        }
        size++;
    }

    public void addLast(T item) {
        final Node<T> l = last;
        final Node<T> newNode = new Node<>(item, last, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    public T removeFirst() {
        final Node<T> f = first;
        T item = f.item;
        Node<T> next = f.next;
        f.item = null;
        f.next = null;
        f.next = null;
        first = next;
        if (next == null) {
            last = null;
        } else {
            next.prev = null;
        }
        size--;
        return item;
    }

    private Node<T> getNode(int index) {
        Node<T> x = first;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }

    private T remove(Node<T> tNode) {
        final T item = tNode.item;
        final Node<T> next = tNode.next;
        final Node<T> prev = tNode.prev;
        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            tNode.next = null;
        }
        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            tNode.prev = null;
        }
        size--;
        return item;
    }

    private T remove(T item) {
        Node<T> x = first;
        for (x = first; x != null; x = x.next) {
            if (item.equals(x.item)) {
                return remove(x);
            }
        }
        return null;
    }


    public T remove(int index) {
        if (size > index && index >= 0) {
            return remove(getNode(index));
        }
        return null;
    }

    public T get(int index) {
        if (size > index && index >= 0) {
            return getNode(index).item;
        }
        return null;
    }

    public void update(int index, T item) {
        if (size > index && index >= 0) {
            Node<T> x = first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            x.item = item;
        }
    }

    public void update(T oldItem, T newItem) {
        if (oldItem != null && newItem != null) {
            Node<T> x = first;
            for (x = first; x != null; x = x.next) {
                if (oldItem.equals(x.item)) {
                    x.item = newItem;
                }
            }
        }
    }

    @Override
    public String toString() {
        List<T> list = new ArrayList<>();
        Node<T> f = first;
        while (f != null) {
            list.add(f.item);
            f = f.next;
        }

        return "MyList{" +
                "size=" + size +
                ", content=" + list +
                '}';
    }

    public static void main(String[] args) {
        MyList<Integer> myList = new MyList<>();
        myList.addLast(7);
        myList.addFirst(1);
        myList.addFirst(2);
        myList.addFirst(2);
        myList.addFirst(1);
        myList.addFirst(2);
        myList.addFirst(3);
        myList.addFirst(1);
        myList.addLast(5);
        myList.addLast(6);
        System.out.println(myList);
        myList.remove(1);
        myList.remove(new Integer(1));
        System.out.println(myList);
        myList.update(new Integer(1), new Integer(108));
        System.out.println(myList);
        myList.update(1, new Integer(99));
        System.out.println(myList);
        System.out.println(myList.get(1));
    }
}
