package 哈希表和字符串;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Class 字母异位词分组 ...
 *
 * @author LiJun
 * Created on 2019/5/3
 */
public class 字母异位词分组 {

    class Solution {
        /**
         * 排序作为键
         *
         * @param strs
         * @return
         */
        public List<List<String>> groupAnagrams(String[] strs) {
            HashMap<String, List<String>> map = new HashMap<>();
            for (String i : strs) {
                char[] temp = i.toCharArray();
                Arrays.sort(temp);
                String str = String.valueOf(temp);
                if (!map.containsKey(str)) {
                    // 若不存在建立映射关系 排序后的字符串—>新的List集合（装未排序的异位词）
                    map.put(str, new ArrayList<>());
                }
                map.get(str).add(i);
            }
            return new ArrayList<>(map.values());
        }

        /**
         * 质数来存储26个字母
         */
        public List<List<String>> groupAnagrams1(String[] strs) {
            /*
            用26个质数来存储26个字母
             */
            int[] arr = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41,
                    43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
            HashMap<Integer, List<String>> map = new HashMap<>();
            for (String s : strs) {
                int temp = 1;
                for (int i = 0; i < s.length(); i++) {
                    temp *= arr[s.charAt(i) - 'a'];
                }
                if (!map.containsKey(temp)) {
                    map.put(temp, new ArrayList<>());
                }
                map.get(temp).add(s);
            }
            return new ArrayList<>(map.values());
        }
    }

}
/*
给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

示例:

输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
说明：

所有输入均为小写字母。
不考虑答案输出的顺序。
 */