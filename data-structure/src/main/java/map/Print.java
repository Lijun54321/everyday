package map;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Class Print ...
 *
 * @author LiJun
 * Created on 2019/4/25
 */
public class Print {

    public void init(Map map) {
        /*
        测试数据：5 6 0 1 0 2 0 4 1 2 2 3 3 4
         */
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入顶点数和边数：");
        int numVertex = scanner.nextInt();
        int numEdge = scanner.nextInt();
        map.init(numVertex, numEdge);
        System.out.print("请依次输入 边集 vi vj ");
        for (int i = 0; i < map.numEdge; i++) {
            int vi = scanner.nextInt();
            int vj = scanner.nextInt();
            map.edge[vi][vj] = 1;
        }
    }

    public static void main(String[] args) {
        Map map = new Map();
        Print print = new Print();
        print.init(map);
        System.out.println();
        System.out.println(map);
        print.DFSTraverse(map);
        System.out.println();
        print.BFSTraverse(map);

    }

    /**
     * 深度优先遍历 DFS
     */
    public void DFSTraverse(Map map) {
        boolean[] visited = new boolean[map.numVertex];
        for (int i = 0; i < map.numVertex; i++) {
            if (!visited[i]) {
                DFS(map, visited, i);
            }
        }
    }

    private void DFS(Map map, boolean[] visited, int i) {
        visited[i] = true;
        System.out.print(i + " ");
        for (int j = 0; j < map.numVertex; j++) {
            if (map.edge[i][j] == 1 && !visited[j]) {
                DFS(map, visited, j);
            }
        }
    }

    /**
     * 广度优先算法
     */
    public void BFSTraverse(Map map) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[map.numVertex];
        for (int i = 0; i < map.numVertex; i++) {
            if (!visited[i]) {
                visited[i] = true;
                System.out.print(i + " ");
                queue.offer(i);
                while (!queue.isEmpty()) {
                    i = queue.poll();
                    for (int j = 0; j < map.numVertex; j++) {
                        if (map.edge[i][j] == 1 && !visited[j]) {
                            visited[j] = true;
                            System.out.print(j + " ");
                            queue.offer(j);
                        }
                    }
                }
            }
        }
    }
}
