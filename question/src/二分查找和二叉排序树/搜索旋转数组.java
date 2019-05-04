package 二分查找和二叉排序树;

/**
 * Class 搜索旋转数组 ...
 *
 * @author LiJun
 * Created on 2019/5/2
 */
public class 搜索旋转数组 {

    static class Solution {
        public int search(int[] nums, int target) {
            if (nums == null || nums.length <= 0) {
                return -1;
            }
            int left = 0;
            int right = nums.length - 1;
            int mid = 0;
            int index = getIndex(nums);
            if (index == 0) {
                return search(nums, 0, nums.length - 1, target);
            } else {
                if (target >= nums[0]) {
                    return search(nums, 0, index - 1, target);
                } else {
                    return search(nums, index, nums.length - 1, target);
                }
            }
        }

        private int search(int[] nums, int left, int right, int target) {
            while (left <= right) {
                int mid = (right + left) >> 1;
                if (nums[mid] == target) {
                    return mid;
                }
                if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return -1;
        }

        private int getIndex(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            int mid = 0;
            while (nums[left] >= nums[right]) {
                // 如果start 和 end 执行相邻的数字
                // 则 start 执行第一个递增数列的最后一个数字
                // end 指向第二个递增数列的第一个数字
                if (right - left == 1) {
                    mid = right;
                    break;
                }
                mid = (left + right) / 2;
                // 这里是特殊情况 如果这三者相等的话，就只能老老实实的顺序查找了
                if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                    return GetMinInOrder(nums, left, right);
                }
                if (nums[mid] >= nums[right]) {
                    left = mid;
                } else if (nums[mid] <= nums[right]) {
                    right = mid;
                }
            }
            return mid;
        }

        public int GetMinInOrder(int[] numbers, int start, int end) {
            int min = numbers[start];
            int midIndex = start;
            for (int i = start + 1; i <= end; i++) {
                if (numbers[i] < min) {
                    min = numbers[i];
                    midIndex = i;
                }
            }
            return midIndex;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4, 0};
        System.out.println(solution.search(new int[]{}, 5));
    }
}
/*
假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

你可以假设数组中不存在重复的元素。

你的算法时间复杂度必须是 O(log n) 级别。

示例 1:

输入: nums = [4,5,6,7,0,1,2], target = 0
输出: 4
示例 2:

输入: nums = [4,5,6,7,0,1,2], target = 3
输出: -1
 */