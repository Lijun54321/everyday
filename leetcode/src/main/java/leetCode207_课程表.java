import java.util.HashSet;
import java.util.Stack;

/**
 * Class leetCode207_课程表 ...
 *
 * @author LiJun
 * Created on 2019/5/2
 */
public class leetCode207_课程表 {
    static class Solution {
        /**
         * dfs
         *
         * @param numCourses
         * @param prerequisites
         * @return
         */
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            boolean[][] graph = new boolean[numCourses][numCourses];
            // 构造一个邻接表
            for (int i = 0; i < prerequisites.length; i++) {
                graph[prerequisites[i][0]][prerequisites[i][1]] = true;
            }
            // 0 表示没被访问 -1 表示正在访问 1 表示访问完成
            int[] visited = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                if (visited[i] == 0) {
                    if (!dfs(graph, visited, i)) {
                        return false;
                    }
                }
            }
            return true;
        }

        private boolean dfs(boolean[][] graph, int[] visited, int i) {
            visited[i] = -1;
            for (int j = 0; j < graph.length; j++) {
                if (graph[i][j] && visited[j] == -1) {
                    return false;
                }
                if (visited[j] == 0 && graph[i][j]) {
                    if (!dfs(graph, visited, j)) {
                        return false;
                    }
                }
            }
            visited[i] = 1;
            return true;
        }

        /**
         * 构建一个邻接矩阵来做， 用set存正在遍历的节点
         */

        public boolean canFinish2(int numCourses, int[][] prerequisites) {
            boolean[][] graph = new boolean[numCourses][numCourses];
            boolean[] visited = new boolean[numCourses];
            /**
             * 构建邻接矩阵
             */
            for (int i = 0; i < prerequisites.length; i++) {
                graph[prerequisites[i][1]][prerequisites[i][0]] = true;
            }
            /**
             * 深度优先搜索
             */
            for (int i = 0; i < numCourses; i++) {
                if (!visited[i]) {
                    if (!dfs(i, graph, visited, new HashSet<>())) {
                        return false;
                    }
                }
            }
            return true;
        }

        private boolean dfs(int index, boolean[][] graph, boolean[] visited, HashSet<Integer> set) {
            visited[index] = true;
            set.add(index);
            for (int i = 0; i < visited.length; i++) {
                if (graph[index][i] && set.contains(i)) {
                    return false;
                }
                if (!visited[i] && graph[index][i]) {
                    if (!dfs(i, graph, visited, set)) {
                        return false;
                    }
                }
            }
            set.remove(index);
            return true;
        }

        /**
         * 广度优先搜索
         * @param numCourses
         * @param prerequisites
         * @return
         */
        public boolean canFinish3(int numCourses, int[][] prerequisites) {
            if (prerequisites.length == 0) {
                return true;
            }
            Stack<Integer> stack = new Stack<>();
            int[] degree = new int[numCourses];
            for (int i = 0; i < prerequisites.length; i++) {
                degree[prerequisites[i][1]]++;
            }
            // 将度为0的课程入栈
            for (int i = 0; i < numCourses; i++) {
                if (degree[i] == 0) {
                    stack.push(i);
                }
            }
            int result = 0;
            while (!stack.isEmpty()) {
                int m = stack.pop();
                result++;
                // 将与m课程连接的定点入度减1，并判断其入度是否为0，若为0则入栈
                for (int i = 0; i < prerequisites.length; i++) {
                    if (prerequisites[i][0] == m) {
                        degree[prerequisites[i][1]]--;
                        if (degree[prerequisites[i][1]] == 0) {
                            stack.push(prerequisites[i][1]);
                        }
                    }
                }
            }
            // 比较结果集与课程数目是否相等
            return result == numCourses;
        }
    }


    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        System.out.println(new Solution().canFinish(2, prerequisites));
        System.out.println(new Solution().canFinish2(2, prerequisites));
        System.out.println(new Solution().canFinish3(2, prerequisites));
    }
}

/*
现在你总共有 n 门课需要选，记为 0 到 n-1。

在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]

给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？

示例 1:

输入: 2, [[1,0]]
输出: true
解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
示例 2:

输入: 2, [[1,0],[0,1]]
输出: false
解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
说明:

输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。
你可以假定输入的先决条件中没有重复的边。
提示:

这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。
通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。
拓扑排序也可以通过 BFS 完成。
 */