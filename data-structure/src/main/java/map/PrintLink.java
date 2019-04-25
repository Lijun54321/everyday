package map;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * Class PrintLink ...
 *
 * @author LiJun
 * Created on 2019/4/25
 */
public class PrintLink {

    public List<List<Integer>> getMap() {
        // 创建的是无向图
        List<List<Integer>> map = new LinkedList<>();
        // 5 6 0 1 0 2 0 4 1 2 2 3 3 4
        // 前两个数代表顶点数和边集
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int edge = scanner.nextInt();
        for (int i = 0; i < num; i++) {
            LinkedList<Integer> temp = new LinkedList<>();
            temp.add(i);
            map.add(temp);
        }
        for (int i = 0; i < edge; i++) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            if (m > n) {
                int temp = m;
                m = n;
                n = temp;
            }
            map.get(m).add(n);
        }
        return map;
    }

    public void toString(List<List<Integer>> map) {
        int i = 0;
        for (List<Integer> temp : map) {
            System.out.println(temp);
        }
    }

    public void DFSTraverse(List<List<Integer>> map) {
        boolean[] visited = new boolean[map.size()];
        for (int i = 0; i < map.size(); i++) {
            if (!visited[i]) {
                DFS(map, visited, i);
            }
        }
    }

    private void DFS(List<List<Integer>> map, boolean[] visited, int i) {
        visited[i] = true;
        System.out.print(map.get(i).get(0) + " ");
        for (int j = 1; j < map.get(i).size(); j++) {
            if (!visited[map.get(i).get(j)]) {
                visited[map.get(i).get(j)] = true;
                DFS(map, visited, map.get(i).get(j));
            }
        }
    }

    public void BFSTraverse(List<List<Integer>> map) {
        boolean[] visited = new boolean[map.size()];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < map.size(); i++) {
            if (!visited[i]) {
                queue.offer(map.get(i).get(0));
                System.out.print(map.get(i).get(0) + " ");
                while (!queue.isEmpty()) {
                    i = queue.poll();
                    for (int j = 1; j < map.get(i).size(); j++) {
                        if (!visited[map.get(i).get(j)]) {
                            visited[map.get(i).get(j)] = true;
                            System.out.print(map.get(i).get(j) + " ");
                            queue.offer(map.get(i).get(j));
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        PrintLink p = new PrintLink();
        List<List<Integer>> map = p.getMap();
        p.toString(map);
        p.DFSTraverse(map);
        System.out.println();
        p.BFSTraverse(map);
    }
}
// 5 6 0 1 0 2 0 4 1 2 2 3 3 4