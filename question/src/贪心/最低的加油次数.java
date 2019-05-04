package 贪心;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Class 最低的加油次数 ...
 *
 * @author LiJun
 * Created on 2019/4/30
 */
public class 最低的加油次数 {
    static class Solution {
        /**
         *  思路大概就是用一个大顶堆存所有的油，当我们的油数达到了目标数就说明走到了，
         *  如果我们可以继续走那就走下去，如果不能那就加油 加前面最大的油
         *  当所有的油都加完了 还是没法继续 就无法到达，返回-1
         * @param target
         * @param startFuel
         * @param stations
         * @return
         */
        public int minRefuelStops(int target, int startFuel, int[][] stations) {
            if (stations.length <= 0) {
                if (target <= startFuel) {
                    return 0;
                } else {
                    return -1;
                }
            }
            Queue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());
            Arrays.sort(stations, Comparator.comparingInt(o -> o[0]));
            int res = 0;
            for (int i = 0; i < stations.length; i++) {
                if(startFuel >= target){
                    return res;
                }
                while (!max.isEmpty() && startFuel < stations[i][0]){
                    startFuel += max.poll();
                    res++;
                }
                if(max.isEmpty() && startFuel < stations[i][0]){
                    return -1;
                }
                max.offer(stations[i][1]);
            }

            while (!max.isEmpty() && startFuel < target) {
                startFuel += max.poll();
                res++;
            }
            if (max.isEmpty() && startFuel < target) {
                return -1;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int target = 100;
        int startFuel = 50;
        int[][] stations = {
                //{10, 60}, {20, 30}, {30, 30}, {60, 40}
                {25, 25}, {50, 50}
        };
        System.out.println(solution.minRefuelStops(target, startFuel, stations));
    }
}
