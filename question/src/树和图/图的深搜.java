package 树和图;

/**
 * Class 图的深搜 ...
 *
 * @author LiJun
 * Created on 2019/5/2
 */
public class 图的深搜 {
    public static void DFS(int[][] graph, String[] vertex) {
        boolean[] visited = new boolean[vertex.length];

        for (int i = 0; i < vertex.length; i++) {
            if (!visited[i]) {
                dfs(graph, vertex, visited, i);
            }
        }
    }

    private static void dfs(int[][] graph, String[] vertex, boolean[] visited, int i) {
        visited[i] = true;
        System.out.print(vertex[i] + " ");
        for (int j = 0; j < vertex.length; j++) {
            if (!visited[j] && graph[i][j] == 1) {
                dfs(graph, vertex, visited, j);
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 0, 1, 0, 1},
                {1, 0, 1, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1},
                {0, 0, 0, 1, 0}
        };
        String[] vertex = {"a", "b", "c", "d", "e"};
        DFS(graph, vertex);
    }
}
