package 贪心;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Class Test ...
 *
 * @author LiJun
 * Created on 2019/4/30
 */
public class Test {
    class Solution {
        public int findMinArrowShots(int[][] points) {
            if (points.length <= 0) {
                return 0;
            }
            Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
            int res = 0;
            int end = points[0][1];
            for (int i = 0; i < points.length; i++) {
                if(points[i][0] <= end){
                    if(end > points[i][1]){
                        end = points[i][1];
                    }
                }else{
                    res++;
                    end = points[i][1];
                }
            }
            return res;
        }
    }
}
