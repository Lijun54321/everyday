import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Class leetCode871_最少加油次数 ...
 *
 * @author LiJun
 * Created on 2019/4/30
 */
public class leetCode871_最少加油次数 {
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
/*
汽车从起点出发驶向目的地，该目的地位于出发位置东面 target 英里处。

沿途有加油站，每个 station[i] 代表一个加油站，
它位于出发位置东面 station[i][0] 英里处，并且有 station[i][1] 升汽油。

假设汽车油箱的容量是无限的，其中最初有 startFuel 升燃料。它每行驶 1 英里就会用掉 1 升汽油。

当汽车到达加油站时，它可能停下来加油，将所有汽油从加油站转移到汽车中。

为了到达目的地，汽车所必要的最低加油次数是多少？如果无法到达目的地，则返回 -1 。

注意：如果汽车到达加油站时剩余燃料为 0，它仍然可以在那里加油。
如果汽车到达目的地时剩余燃料为 0，仍然认为它已经到达目的地。



示例 1：

输入：target = 1, startFuel = 1, stations = []
输出：0
解释：我们可以在不加油的情况下到达目的地。
示例 2：

输入：target = 100, startFuel = 1, stations = [[10,100]]
输出：-1
解释：我们无法抵达目的地，甚至无法到达第一个加油站。
示例 3：

输入：target = 100, startFuel = 10, stations = [[10,60],[20,30],[30,30],[60,40]]
输出：2
解释：
我们出发时有 10 升燃料。
我们开车来到距起点 10 英里处的加油站，消耗 10 升燃料。将汽油从 0 升加到 60 升。
然后，我们从 10 英里处的加油站开到 60 英里处的加油站（消耗 50 升燃料），
并将汽油从 10 升加到 50 升。然后我们开车抵达目的地。
我们沿途在1两个加油站停靠，所以返回 2 。


提示：

1 <= target, startFuel, stations[i][1] <= 10^9
0 <= stations.length <= 500
0 < stations[0][0] < stations[1][0] < ... < stations[stations.length-1][0] < target

 */