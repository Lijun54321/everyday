package list;

/**
 * Class ResverseList ...
 *
 * @author LiJun
 * Created on 2019/4/7
 */
public class ResverseList<T> {
    private static class MyList<T> {
        T val;
        MyList<T> next;

        MyList(T val, MyList<T> next) {
            this.val = val;
            this.next = next;
        }

        MyList(T val) {
            this.val = val;
        }

        void listPrint() {
            MyList<T> tMyList = this;
            while (tMyList != null) {
                System.out.print(tMyList.val + " ");
                tMyList = tMyList.next;
            }
            System.out.println();
        }
    }

    /**
     * 头插法
     */
    private MyList<T> insertionHead(MyList<T> head, T val) {
        return new MyList<>(val, head);
    }

    /**
     * 尾插
     */
    private MyList<T> insertionTail(MyList<T> head, T val) {
        if (head == null) {
            return new MyList<>(val);
        }
        MyList<T> p = head;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new MyList<>(val);
        return head;
    }

    /**
     * 反转链表
     */
    private MyList<T> reserverList(MyList<T> head) {
        if (head == null || head.next == null) {
            return head;
        }

        MyList<T> p = head.next;
        head.next = null;
        while (p != null) {
            MyList<T> temp = p.next;
            p.next = head;
            head = p;
            p = temp;
        }
        return head;

    }

    public static void main(String[] args) {
        ResverseList<Integer> test = new ResverseList<>();
        MyList<Integer> head = null;
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int num : nums) {
            head = test.insertionHead(head, num);

        }
        head.listPrint();
        head = test.reserverList(head);
        head.listPrint();

    }

}
