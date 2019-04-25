package day;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Class 数据流中的中位数 ...
 *
 * @author LiJun
 * Created on 2019/4/25
 */
public class 数据流中的中位数 {
    class MedianFinder {
        PriorityQueue<Integer> maxHeap, minHeap;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        }

        public void addNum(int num) {
            //关键在这个函数
            //在max里把最小的数放到min里去
            //在min里把最大的数在放到max里去
            maxHeap.offer(num);
            assert maxHeap.peek() != null;
            minHeap.offer(maxHeap.poll());
            if (maxHeap.size() < minHeap.size()) {
                //把minHeap的最大的元素再拿下来
                maxHeap.offer(minHeap.poll());
            }
        }

        public double findMedian() {
            if (maxHeap.size() == minHeap.size()) {
                return (maxHeap.peek() + minHeap.peek()) / 2.0;
            } else {
                return maxHeap.peek();
            }
        }
    }
}
