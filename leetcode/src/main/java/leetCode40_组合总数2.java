import java.util.*;

/**
 * Class leetCode40_组合总数2 ...
 *
 * @author LiJun
 * Created on 2019/5/1
 */
public class leetCode40_组合总数2 {
    static class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            System.out.println(Arrays.toString(candidates));
            Set<List<Integer>> result = new LinkedHashSet<>();
            generate(0, candidates, new LinkedList<>(), result, 0, target);
            return new LinkedList<>(result);
        }

        private void generate(int i, int[] nums,
                              List<Integer> item, Set<List<Integer>> result,
                              int sum, int target) {
            if (target == 0) {
                result.add(new LinkedList<>());
                return;
            }
            // 当sum > target 之后就不处理了，剪枝成功
            if (sum > target || i >= nums.length) {
                return;
            }
            sum += nums[i];
            item.add(nums[i]);
            if (sum == target) {
                result.add(new LinkedList<>(item));
            }
            generate(i + 1, nums, item, result, sum, target);
            sum -= nums[i];
            item.remove(item.size() - 1);
            generate(i + 1, nums, item, result, sum, target);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] candidates = {14, 6, 25, 9, 30, 20, 33, 34, 28, 30, 16,
                12, 31, 9, 9, 12, 34, 16, 25, 32, 8, 7, 30, 12, 33, 20,
                21, 29, 24, 17, 27, 34, 11, 17, 30, 6, 32, 21, 27, 17,
                16, 8, 24, 12, 12, 28, 11, 33, 10, 32, 22, 13, 34, 18, 12};
        int target = 27;
        for (List list : solution.combinationSum2(candidates, target)) {
            System.out.println(list);
        }
    }
}
/*
给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的每个数字在每个组合中只能使用一次。

说明：

所有数字（包括目标数）都是正整数。
解集不能包含重复的组合。
示例 1:

输入: candidates = [10,1,2,7,6,1,5], target = 8,
所求解集为:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
示例 2:

输入: candidates = [2,5,2,1,2], target = 5,
所求解集为:
[
  [1,2,2],
  [5]
]
 */
