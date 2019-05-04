package 递归回溯分治;

import java.util.*;

/**
 * Class 求子集2 ...
 *
 * @author LiJun
 * Created on 2019/4/30
 */
public class 求子集2 {
    static class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            // 利用set来去重
            Set<List<Integer>> temp = new LinkedHashSet<>();
            int total = 1 << nums.length;
            for (int i = 0; i < total; i++) {
                List<Integer> item = new LinkedList<>();
                for (int j = 0; j < nums.length; j++) {
                    if ((i & (1 << j)) != 0) {
                        item.add(nums[j]);
                    }
                }
                temp.add(item);
            }
            return new LinkedList<>(temp);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        Solution solution = new Solution();
        List<List<Integer>> result = solution.subsetsWithDup(nums);
        for (List list : result) {
            System.out.println(list);
        }

    }
}
