import java.util.Arrays;
import java.util.Stack;

/**
 * Class Buffer ...
 *
 * @author LiJun
 * Created on 2018/12/18
 */
public class Buffer<T> {
    /**
     * 头指针
     */
    private int head;
    /**
     * 环形缓冲区
     */

    private T[] buffer = null;
    /**
     * 环形缓冲区大小
     */
    private int size;
    /**
     * 尾指针
     */
    private int tail;

    /**
     * 使用计数
     */
    private int count;

    /**
     * 移栈数
     */
    private int maxSize;
    /**
     * 后备栈
     */
    private Stack<T> bufferStack;

    public boolean put(T data) {

        if (data == null) {
            System.out.println("数据为空，不能插入！");
            return false;
        }
        if (count >= maxSize) {
            bufferStack.push(buffer[tail]);
            bufferStack.push(buffer[tail + 1]);
            tail = (tail + 2) % size;
            count -= 2;
            System.out.println("移入后备栈");
        }
        buffer[head] = data;
        head = (head + 1) % size;
        count++;
        System.out.println("插入数据" + data + "成功");
        return true;
    }

    public T get() {

        if (count > 0) {
            if (head <= 0) {
                head += size;
            }
            head--;
            head = head % size;
            T data = buffer[head];
            count--;
            System.out.print("环形缓冲区取出数据 ");
            return data;
        } else if (bufferStack.size() > 0) {

            System.out.print("后备栈取出数据 ");
            return bufferStack.pop();
        } else {
            System.out.println("缓冲区为空！");
            return null;
        }
    }

    public Buffer() {
    }

    public Buffer(int size, int maxSize) {
        // 缓冲区初始化
        this.buffer = (T[]) new Object[size];
        // 初始化全为0
        this.head = this.tail = 0;
        this.count = 0;
        this.size = size;
        this.maxSize = maxSize;
        bufferStack = new Stack<>();
    }

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public T[] getBuffer() {
        return buffer;
    }

    public void setBuffer(T[] buffer) {
        this.buffer = buffer;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTail() {
        return tail;
    }

    public void setTail(int tail) {
        this.tail = tail;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public Stack<T> getBufferStack() {
        return bufferStack;
    }

    public void setBufferStack(Stack<T> bufferStack) {
        this.bufferStack = bufferStack;
    }

    @Override
    public String toString() {
        return "Buffer{" +
                "head=" + head +
                ", buffer=" + Arrays.toString(buffer) +
                ", size=" + size +
                ", tail=" + tail +
                ", count=" + count +
                ", maxSize=" + maxSize +
                ", bufferStack=" + bufferStack +
                '}';
    }
}
