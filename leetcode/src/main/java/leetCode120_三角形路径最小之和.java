import java.util.Collections;
import java.util.List;

/**
 * Class 三角形路径最小之和 ...
 *
 * @author LiJun
 * Created on 2019/5/4
 */
public class leetCode120_三角形路径最小之和 {
    class Solution {
        /**
         * 从下往推导
         *
         * @param triangle
         * @return
         */
        public int minimumTotal(List<List<Integer>> triangle) {
            if (triangle.size() == 0) {
                return 0;
            }

            for (int i = triangle.size() - 2; i >= 0; i--) {
                List<Integer> last = triangle.get(i + 1);
                List<Integer> t = triangle.get(i);
                for (int j = 0; j < t.size(); j++) {
                    t.set(j, t.get(j) + Math.min(last.get(j), last.get(j + 1)));
                }
            }
            return triangle.get(0).get(0);
        }

        /**
         * 从上到下推导
         *
         * @param triangle
         * @return
         */
        public int minimumTotal1(List<List<Integer>> triangle) {
            if (triangle.size() == 0) {
                return 0;
            }
            for (int i = 1; i < triangle.size(); i++) {
                List<Integer> pre = triangle.get(i - 1);
                List<Integer> last = triangle.get(i);
                for (int j = 0; j < last.size(); j++) {
                    int x = j - 1 >= 0 ? j - 1 : 0;
                    int y = j < pre.size() ? j : pre.size() - 1;
                    last.set(j, last.get(j) + Math.min(pre.get(x), pre.get(y)));
                }
            }
            return Collections.min(triangle.get(triangle.size() - 1));
        }
    }

}
/*
给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。

例如，给定三角形：

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。

说明：

如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 */