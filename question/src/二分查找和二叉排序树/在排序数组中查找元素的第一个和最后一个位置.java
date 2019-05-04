package 二分查找和二叉排序树;

import java.util.Arrays;

/**
 * Class 在排序数组中查找元素的第一个和最后一个位置 ...
 *
 * @author LiJun
 * Created on 2019/5/2
 */
public class 在排序数组中查找元素的第一个和最后一个位置 {
    static class Solution {
        public int[] searchRange(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = (right + left) >> 1;
                if (nums[mid] == target) {
                    int end = mid;
                    int start = mid;
                    while (start >= 0) {
                        if (nums[start] == target) {
                            start--;
                        } else {
                            break;
                        }
                    }
                    while (end < nums.length) {
                        if (nums[end] == target) {
                            end++;
                        } else {
                            break;
                        }
                    }
                    return new int[]{start + 1, end - 1};
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return new int[]{-1, -1};
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(new Solution().searchRange(nums, 8)));
    }
}
