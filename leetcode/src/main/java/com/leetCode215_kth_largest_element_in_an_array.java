package com;

import java.util.PriorityQueue;

/**
 * Class leetCode215_kth_largest_element_in_an_array ...
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 *
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * @author LiJun
 * Created on 2019/4/24
 */
public class leetCode215_kth_largest_element_in_an_array {
    class Solution {
        /**
         * 利用k大小的小根堆来做
         * @param nums
         * @param k
         * @return
         */
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
}
