package day;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Class day23_两数之和 ...
 *
 * @author LiJun
 * Created on 2019/4/8
 */
public class day23_两数之和 {
    static class Solution {
        /**
         * 跑了一百多毫秒，因为linkedlist contains 要遍历
         */
        public int[] twoSum(int[] nums, int target) {
            LinkedList<Integer> linkedList = new LinkedList();
            for (int i = 0; i < nums.length; i++) {
                if (linkedList.contains(nums[i])) {
                    return new int[]{linkedList.indexOf(nums[i]), i};
                }
                linkedList.add(target - nums[i]);
            }
            return null;
        }

        /**
         * 这个就只需要 6ms
         */
        public int[] twoSum1(int[] nums, int target) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if(map.containsKey(target - nums[i])){
                    return new int[]{map.get(target-nums[i]), i};
                }
                if (!map.containsKey(nums[i])) {
                    map.put(nums[i], i);
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {

        int[] arr = {2, 7, 11, 15};

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.twoSum1(arr, 9)));
    }

}
