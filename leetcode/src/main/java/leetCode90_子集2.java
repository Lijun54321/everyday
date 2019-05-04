import java.util.*;

/**
 * Class leetCode90_子集2 ...
 *
 * @author LiJun
 * Created on 2019/4/30
 */
public class leetCode90_子集2 {
    class Solution {
        /**
         * 利用set来去重
         */
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> result = new LinkedList<>();
            Set<List<Integer>> temp = new LinkedHashSet<>();
            int total = 1 << nums.length;
            for (int i = 0; i < total; i++) {
                List<Integer> item = new LinkedList<>();
                for (int j = 0; j < nums.length; j++) {
                    if ((i & (1 << j)) != 0) {
                        item.add(nums[j]);
                    }
                }
                if (temp.add(item)) {
                    result.add(item);
                }
            }
            return result;
        }
    }
}
/*
给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: [1,2,2]
输出:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]

 */