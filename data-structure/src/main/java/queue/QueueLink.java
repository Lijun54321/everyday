package queue;

/**
 * Class QueueLink ...
 *
 * @author LiJun
 * Created on 2019/4/12
 */
public class QueueLink {
    private int count;
    private QueueLinkNode front;
    private QueueLinkNode rear;

    public QueueLink() {
        this.count = 0;
        this.front = this.rear = null;
    }
    public boolean put(int data){
        if(rear == null){
            rear = new QueueLinkNode(data);
            front = rear;
        }else{
            rear.next = new QueueLinkNode(data);
            rear = rear.next;
        }
        return true;
    }
    public int poll() throws Exception {
        if(front == null) {
            throw new Exception("Queue is empty!");
        }
        int data = front.data;
        front = front.next;
        return data;
    }

    public static void main(String[] args) {
        QueueLink queue = new QueueLink();
        for(int i = 0; i < 10; i++){
            System.out.print(queue.put(i) + " ");
        }
        System.out.println();
        for(int i = 0;i < 11; i++){
            try {
                System.out.print(queue.poll() + " ");
            } catch (Exception e) {
                System.out.println();
                e.printStackTrace();
            }
        }
        System.out.println();
    }
}
