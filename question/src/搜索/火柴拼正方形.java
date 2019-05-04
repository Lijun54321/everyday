package 搜索;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class 火柴拼正方形 ...
 *
 * @author LiJun
 * Created on 2019/5/3
 */
public class 火柴拼正方形 {
    static class Solution {
        public boolean makesquare1(int[] nums) {
            if (nums == null || nums.length < 4) {
                return false;
            }
            // 排序进行加和
            int result = 0;
            for (int i = 0; i < nums.length; i++) {
                result += nums[i];
            }
            // 如果出现大于边长的数，那么肯定不能拼成正方形
            if (result % 4 != 0 || result / 4 < nums[nums.length - 1]) {
                return false;
            }
            Arrays.parallelSort(nums);
            int[] bucket = new int[4];
            return generate(0, nums, result / 4, bucket);
        }

        private boolean generate(int i, int[] nums, int target, int[] bucket) {
            if (i >= nums.length) {
                return bucket[0] == target && bucket[1] == target
                        && bucket[2] == target && bucket[3] == target;
            }
            for (int j = 0; j < 4; j++) {
                if (bucket[j] + nums[i] > target) {
                    continue;
                }
                bucket[j] += nums[i];
                if (generate(i + 1, nums, target, bucket)) {
                    return true;
                }
                bucket[j] -= nums[i];
            }
            return false;
        }

        public boolean makesquare(int[] nums) {
            if (nums == null || nums.length < 4) {
                return false;
            }
            // 排序进行加和
            int result = 0;
            for (int i = 0; i < nums.length; i++) {
                result += nums[i];
            }
            // 如果出现大于边长的数，那么肯定不能拼成正方形
            if (result % 4 != 0 || result / 4 < nums[nums.length - 1]) {
                return false;
            }
            int target = result / 4;
            List<Integer> ok_subset = new ArrayList<>();
            List<Integer> ok_half = new ArrayList<>();
            int all = 1 << nums.length;
            for (int i = 0; i < all; i++) {
                int sum = 0;
                for (int j = 0; j < nums.length; j++) {
                    if ((i & (1 << j)) != 0) {
                        sum += nums[j];
                    }
                }
                if (sum == target) {
                    ok_subset.add(i);
                }
            }
            for (int i = 0; i < ok_subset.size(); i++) {
                for (int j = i + 1; j < ok_subset.size(); j++) {
                    if (((ok_subset.get(i) & ok_subset.get(j)) == 0)) {
                        ok_half.add(ok_subset.get(i) | ok_subset.get(j));
                    }
                }
            }
            // 已经有满足正方形一半的边了，再找另一半有没有满足的，有的话，就可以返回true了
            for (int i = 0; i < ok_half.size(); ++i) {
                for (int j = i + 1; j < ok_half.size(); ++j) {
                    if (((ok_half.get(i) & ok_half.get(j)) == 0)) {
                        return true;
                    }
                }
            }
            return false;

        }
    }


    public static void main(String[] args) {

        int[] nums = {7215807, 6967211, 5551998, 6632092,
                2802439, 821366, 2465584, 9415257, 8663937,
                3976802, 2850841, 803069, 2294462, 8242205, 9922998};
        Solution solution = new Solution();
        System.out.println(solution.makesquare1(nums));

    }

}
/*
还记得童话《卖火柴的小女孩》吗？现在，你知道小女孩有多少根火柴，
请找出一种能使用所有火柴拼成一个正方形的方法。不能折断火柴，可以把火柴连接起来，并且每根火柴都要用到。

输入为小女孩拥有火柴的数目，每根火柴用其长度表示。输出即为是否能用所有的火柴拼成正方形。

示例 1:

输入: [1,1,2,2,2]
输出: true

解释: 能拼成一个边长为2的正方形，每边两根火柴。
示例 2:

输入: [3,3,3,3,4]
输出: false

解释: 不能用所有火柴拼成一个正方形。
注意:

给定的火柴长度和在 0 到 10^9之间。
火柴数组的长度不超过15。
 */