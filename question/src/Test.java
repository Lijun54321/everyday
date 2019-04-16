/**
 * Class Test ...
 *
 * @author LiJun
 * Created on 2019/3/16
 */


public class Test {
    public static void main(String[] args) {

        int[][] array = {
                {1, 6, 3, 1, 1, 1},
                {6, 0, 2, 5, 1, 1},
                {3, 2, 0, 3, 4, 1},
                {1, 5, 3, 0, 2, 3},
                {6, 7, 4, 7, 5, 2},
                {2, 6, 1, 3, 4, 9}};
    }


    public static int dijkstra(int[][] array, int v0, int[] path) {
        // 参数有效性检测
        if (array == null || array.length <= 0 || array[0].length <= 0 && v0 > 0) {
            return Integer.MAX_VALUE;
        }
        // 计算数据总数
        int length = array.length * array[0].length;

        boolean[] find = new boolean[length];
        int[] dis = new int[length];
        for (int i = 0; i < length; i++) {
            // -1 表示不可达
            dis[i] = -1;
            find[i] = false;
        }
        dis[v0] = 0;

        find[v0] = true;
        for (int i = 0; i < length - 1; i++) {
            int minIndex = 0;
            int minValue = Integer.MAX_VALUE;
            for (int j = 0; j < length; j++) {

                if (!find[j] && dis[j] < minValue && dis[j] != -1) {
                    minValue = dis[j];
                    minIndex = j;
                }
            }
            find[minIndex] = true;
            for (int j = 0; j < length; j++) {
                if (!find[j] && array[minIndex][j] > 0 && dis[j] > dis[minIndex] + array[minIndex][j]) {
                    dis[j] = dis[minIndex] + array[minIndex][j];
                }
            }
        }
        for (int i = 0; i < length; i++) {
            System.out.println(dis[i]);
        }
        return Integer.parseInt(null);
    }
}