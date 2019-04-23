package queue;

/**
 * Class QueueArray ...
 *
 * @author LiJun
 * Created on 2019/4/12
 */
public class QueueArray {
    private QueueNodeArray queue;

    public QueueArray() {
        this.queue = new QueueNodeArray();
    }

    public QueueArray(int maxSize) {
        this.queue = new QueueNodeArray(maxSize);
    }

    public int poll() throws Exception {
        if (empty()) {
            throw new Exception("Queue is empty!");
        }
        int data = queue.data[queue.front];
        queue.front = (queue.front + 1) % queue.maxSize;
        return data;
    }

    public boolean put(int data) throws Exception {
        // 先判满啊
        if (full()) {
            throw new Exception("Queue is full!");
        }
        queue.data[queue.rear] = data;
        queue.rear = (queue.rear + 1) % queue.maxSize;
        return true;
    }

    public boolean empty() {
        return queue.rear == queue.front;
    }

    public boolean full() {
        return (queue.rear + 1) % queue.maxSize == queue.front;
    }

    public static void main(String[] args) {
        QueueArray queue = new QueueArray();
        for(int i = 0; i < 10; i++){
            try {
                System.out.print(queue.put(i) + " ");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println();
        for(int i = 0; i < 10; i++){
            try {
                System.out.print(queue.poll() + " ");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }

}
