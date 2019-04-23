package queue;

/**
 * Class QueueLinkNode ...
 *
 * @author LiJun
 * Created on 2019/4/12
 */
public class QueueLinkNode {
    public int data;
    public QueueLinkNode next;

    public QueueLinkNode(int data) {
        this.data = data;
        this.next = null;
    }

    public QueueLinkNode(int data, QueueLinkNode next) {
        this.data = data;
        this.next = next;
    }
}
