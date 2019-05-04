package 递归回溯分治;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Class 计算右侧小于当前元素的个数 ...
 *
 * @author LiJun
 * Created on 2019/5/1
 */
public class 计算右侧小于当前元素的个数 {
    class Solution {
        public List<Integer> countSmaller(int[] nums) {
            List<Integer> temp = new ArrayList<>();
            Integer[] res = new Integer[nums.length];
            for (int i = nums.length - 1; i >= 0; i--) {
                int left = 0, right = temp.size();
                while (left < right) {
                    int mid = left + ((right - left) >> 1);
                    if (temp.get(mid) >= nums[i]) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
                res[i] = left;
                temp.add(left, nums[i]);
            }
            return Arrays.asList(res);
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<Integer> result = new LinkedList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int left = 0;
            int right = list.size();
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (list.get(mid) >= nums[i]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            result.add(0, left);
            list.add(left, nums[i]);

        }
        return result;
    }

    public static void main(String[] args) {
    }
}
/*
给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质：
counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。

示例:

输入: [5,2,6,1]
输出: [2,1,1,0]
解释:
5 的右侧有 2 个更小的元素 (2 和 1).
2 的右侧仅有 1 个更小的元素 (1).
6 的右侧有 1 个更小的元素 (1).
1 的右侧有 0 个更小的元素.
 */