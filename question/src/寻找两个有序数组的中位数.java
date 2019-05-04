/**
 * Class 寻找两个有序数组的中位数 ...
 *
 * @author LiJun
 * Created on 2019/4/25
 */
public class 寻找两个有序数组的中位数 {
    static class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int len = nums1.length + nums2.length;
            int mid = len / 2;
            int count = 0;
            int temp = 0;
            int num = 0;
            int i = 0, j = 0;
            while (count <= mid) {
                if (i >= nums1.length && j >= nums2.length) {
                    break;
                }
                if (i < nums1.length && j < nums2.length && nums1[i] < nums2[j]) {
                    num = temp;
                    temp = nums1[i++];
                } else if (i < nums1.length && j < nums2.length && nums1[i] >= nums2[j]) {
                    num = temp;
                    temp = nums2[j++];
                } else if (i >= nums1.length) {
                    num = temp;
                    temp = nums2[j++];
                } else if (j >= nums2.length) {
                    num = temp;
                    temp = nums1[i++];
                }
                count++;
            }
            if (len % 2 == 0) {
                return (num + temp) / 2.0;
            }
            return temp;
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        // 保证B的长度大于等于A的长度
        if (m > n) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            int tmp = m;
            m = n;
            n = tmp;
        }
        int min = 0, max = m, mid = (m + n + 1) / 2;
        while (min <= max) {
            int i = (min + max) / 2;
            int j = mid - i;
            if (i < max && nums2[j - 1] > nums1[i]) {
                min = i + 1;
            } else if (i > min && nums1[i - 1] > nums2[j]) {
                max = i - 1;
            } else {
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i == m) {
                    minRight = nums2[j];
                } else if (j == n) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums2[j], nums1[i]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = {1, 3, 5, 7};
        int[] b = {2};
        System.out.println(solution.findMedianSortedArrays(a, b));
    }
}
