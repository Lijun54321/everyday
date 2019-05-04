package 二分查找和二叉排序树;

import java.util.Arrays;

/**
 * Class 二分查找算法 ...
 *
 * @author LiJun
 * Created on 2019/5/2
 */
public class 二分查找算法 {
    public static boolean exist(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right + left) >> 1;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public static void getResult(int[] nums1, int[] nums2, int[] nums3) {
        // 时间复杂度在 O(nlogn)
        for (int i = 0; i < nums2.length; i++) {
            nums3[i] = exist(nums1, nums2[i]) ? 1 : 0;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {-1, 2, 5, 20, 90, 100, 207, 800};
        int[] nums2 = {50, 90, 3, -1, 207, 80};
        int[] nums3 = new int[nums2.length];
        getResult(nums1, nums2, nums3);
        System.out.println(Arrays.toString(nums3));
    }
}
/*
已知一个排序数组A，如A = {-1, 2, 5, 20, 90, 100, 207, 800},
和一个乱序数组B，如B = {50, 90, 3, -1, 207, 80},
求B中的任意某个元素是否在A中出现，结果存储在数组C中，出现用1表示，未出现用0表示，
如， C = {0, 1, 0, 1, 1, 0}
 */