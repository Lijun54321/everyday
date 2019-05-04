package 树和图;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Class 图的广搜 ...
 *
 * @author LiJun
 * Created on 2019/5/2
 */
public class 图的广搜 {
    public static void BFS(int[][] graph, String[] vertex){
        boolean[] visited = new boolean[vertex.length];
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < vertex.length; i++){
            if(!visited[i]){
                visited[i] = true;
                System.out.print(vertex[i] + " ");
                queue.offer(i);
                while(!queue.isEmpty()){
                    int t = queue.poll();
                    for(int j = 0; j < vertex.length; j ++){
                        if(!visited[j] && graph[t][j] == 1){
                            visited[j] = true;
                            System.out.print(vertex[j] + " ");
                            queue.offer(j);
                        }
                    }
                }
            }
        }
        System.out.println();
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
        BFS(graph, vertex);
    }
}
