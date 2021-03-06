package 贪心;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Class 用最少数量的箭引爆气球 ...
 *
 * @author LiJun
 * Created on 2019/4/27
 */
public class 用最少数量的箭引爆气球 {
    static class Solution {
        public int findMinArrowShots(int[][] points) {
            if(points.length == 0){
                return 0;
            }
            Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
            for (int i = 0; i < points.length; i++) {
                System.out.println(Arrays.toString(points[i]));
            }
            int res = 1;
            int end = points[0][1];
            for (int i = 1; i < points.length; i++) {
                if (points[i][0] <= end) {
                    if (end > points[i][1]) {
                        end = points[i][1];
                    }
                } else {
                    res++;
                    end = points[i][1];
                }
            }
            return res;
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{3, 9}, {7, 12}, {3, 8}, {6, 8}, {9, 10}, {2, 9}, {0, 9}, {3, 9}, {0, 6}, {2, 8}};
        int[][] points = {
                {3, 9}, {7, 12}, {3, 8},
                {6, 8}, {9, 10}, {2, 9},
                {0, 9}, {3, 9}, {0, 6}, {2, 8}
        };
        int[][] a = {{9, 12}, {1, 10}, {4, 11}, {8, 12}, {3, 9}, {6, 9}, {6, 7}};
        System.out.println(solution.findMinArrowShots(points));

    }
}
/*
在二维空间中有许多球形的气球。对于每个气球，
提供的输入是水平方向上，气球直径的开始和结束坐标。
由于它是水平的，所以y坐标并不重要，因此只要知道开始和结束的x坐标就足够了。
开始坐标总是小于结束坐标。平面内最多存在104个气球。

一支弓箭可以沿着x轴从不同点完全垂直地射出。在坐标x处射出一支箭，
若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。

Example:

输入:
[[10,16], [2,8], [1,6], [7,12]]

输出:
2

解释:
对于该样例，我们可以在x = 6（射爆[2,8],[1,6]两个气球）和 x = 11（射爆另外两个气球）。
 */