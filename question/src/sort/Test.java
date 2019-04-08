package sort;

import java.util.HashMap;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            // 记录n和m
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[][] array = new int[n][n];
            // 将整个图初始化为0
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    array[i][j] = 0;
                }
            }
            // 拿map存下每次连接的地方，后面减的时候要用到
            HashMap<Integer, String> hashMap = new HashMap<>();
            for (int i = 0; i < m; i++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                array[a - 1][b - 1] = 1;
                array[b - 1][a - 1] = 1;
                hashMap.put(i, a + "," + b);
            }
            // 存剪的数 (本来想的是边输入剪n哪根线的时候，这个时候就开始判断，
            // 但是后面想了下，如果我们找都了，如果不break的话，就会多输出来
            // 如果我们break掉，就会不会接受在那后面输入进来的其余剪的数，所以我这直接存起来了)
            int[] cut = new int[m];
            for (int i = 0; i < m; i++) {
                cut[i] = scanner.nextInt();
            }
            // 先计算出我们在原数组上遍历出的结果个数，
            // 当后面遍历个数不相等的时候，就说明这个已经断片了
            int result = DFSTraverse(array);
            for (int i = 0; i < m; i++) {
                // 从剪数组中找出，我们需要剪断哪两个数之间的光缆
                int a = cut[i];
                String str = hashMap.get(a - 1);
                String[] split = str.split(",");
                a = Integer.valueOf(split[0]);
                int b = Integer.valueOf(split[1]);
                // 置相应位置为0   这里我们可以只用一半的 其实是对称矩阵
                array[a - 1][b - 1] = 0;
                // array[b - 1][a - 1] = 0;
                // 剪短一根绳子之后判断是否和没剪之前遍历得到的个数相等，等就继续
                // 不等的话，那么就代表我们已经找到我们所要的结果了，打印出来
                if (result != DFSTraverse(array)) {
                    System.out.println(i + 1);
                    break;
                }
            }
        }
    }

    private static void DFS(int[][] arr, int i, boolean[] visit) {
        visit[i] = true;
        for (int j = 0; j < arr.length; j++) {
            if (arr[i][j] == 1 && !visit[j]) {
                DFS(arr, j, visit);
            }
        }
    }

    private static int DFSTraverse(int[][] array) {
        boolean[] visit = new boolean[array.length];
        for (int i = 0; i < array.length; i++) {
            visit[i] = false;
        }
        // 在这的话注意一下 ，我们只需要从跟节点开始遍历就好了
        DFS(array, 0, visit);
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (visit[i]) {
                count++;
            }
        }
        return count;
    }
// 这里提供一个测试数据，需要的直接
/*
4 5
1 2
1 3
1 4
2 3
3 4
1
2
3
4
5
*/
}
