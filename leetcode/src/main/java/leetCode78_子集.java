import java.util.LinkedList;
import java.util.List;

/**
 * Class leetCode78_子集 ...
 *
 * @author LiJun
 * Created on 2019/4/30
 */
public class leetCode78_子集 {
    class Solution {
        public List<List<Integer>> subsets1(int[] nums) {

            List<Integer> item = new LinkedList<>();
            List<List<Integer>> result = new LinkedList<>();

            result.add(item);
            generate(0, nums, item, result);
            return result;
        }

        public List<List<Integer>> subsets(int[] nums) {
            // 位运算法 用进制位表示可取
            List<List<Integer>> result = new LinkedList<>();
            // 设置全部集合的最大数量
            int t = 1 << nums.length;
            // 遍历所有集合
            for (int i = 0; i < t; i++) {
                List<Integer> item = new LinkedList<>();
                for (int j = 0; j < nums.length; j++) {
                    // 构造数字i代表的集合，各元素存储值item
                    if ((i & (1 << j)) != 0) {
                        item.add(nums[j]);
                    }
                }
                result.add(item);
            }
            return result;
        }

        private void generate(int i, int[] nums, List<Integer> item, List<List<Integer>> result) {
            if (i >= nums.length) {
                return;
            }
            item.add(nums[i]);
            result.add(new LinkedList<>(item));
            generate(i + 1, nums, item, result);
            item.remove(item.size() - 1);
            generate(i + 1, nums, item, result);
        }

        public void test() {
            int[] nums = {1, 2, 3};
            List<Integer> item = new LinkedList<>();
            List<List<Integer>> result = subsets(nums);

            for (List list : result) {
                System.out.println(list);
            }
            result.clear();
            result = subsets1(nums);
            for (List list : result) {
                System.out.println(list);
            }
        }
    }
}
/*
给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: nums = [1,2,3]
输出:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

 */