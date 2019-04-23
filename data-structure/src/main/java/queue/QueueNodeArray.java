package queue;

/**
 * Class QueueNodeArray ...
 *
 * @author LiJun
 * Created on 2019/4/12
 */
public class QueueNodeArray {
    private final int DEFAULT_MAX_SIZE = 10;
    /**
     * 最大值
     */
    public int maxSize;
    /**
     * 数组存队列
     */
    public int[] data;
    /**
     * 头指针
     */
    public int front;
    /**
     * 尾指针
     */
    public int rear;

    public QueueNodeArray() {
        this.maxSize = DEFAULT_MAX_SIZE;
        this.data = new int[DEFAULT_MAX_SIZE];
        this.front = this.rear = 0;
    }

    public QueueNodeArray(int maxSize) {
        this.maxSize = maxSize;
        this.data = new int[maxSize];
        this.front = this.rear = 0;
    }
}
