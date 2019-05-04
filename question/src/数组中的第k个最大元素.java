import java.util.PriorityQueue;

/**
 * Class day.数组中的第k个最大元素 ...
 *
 * @author LiJun
 * Created on 2019/4/24
 */
public class 数组中的第k个最大元素 {
    static class Solution {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
            for (int i : nums) {
                if (minHeap.size() < k) {
                    minHeap.offer(i);
                } else if (minHeap.peek() < i) {
                    Integer poll = minHeap.poll();
                    poll = null;
                    minHeap.offer(i);
                }
            }
            System.out.println(minHeap);
            return minHeap.size() <= 0 ? 0 : minHeap.peek();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.println(solution.findKthLargest(nums, 2));
    }

}
