package 递归回溯分治;

import java.util.LinkedList;
import java.util.List;

/**
 * Class 求子集 ...
 *
 * @author LiJun
 * Created on 2019/4/30
 */
public class 求子集 {
    static class Solution {
        public List<List<Integer>> subsets1(int[] nums) {
            // ji回溯法解决，时间大概就是2^n
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

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<Integer> item = new LinkedList<>();
        Solution solution = new Solution();
        List<List<Integer>> result;
        result = solution.subsets1(nums);
        for (List list : result) {
            System.out.println(list);
        }

        List<List<Integer>> subsets = solution.subsets(nums);
        for (List list : subsets) {
            System.out.println(list);
        }
    }
}
