package 搜索;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Class 岛屿数量 ...
 *
 * @author LiJun
 * Created on 2019/5/3
 */
public class 岛屿数量 {
    class Solution {
        public int numIslands(char[][] grid) {
            if (grid == null || grid.length <= 0) {
                return 0;
            }
            boolean[][] mark = new boolean[grid.length][grid[0].length];
            int result = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (!mark[i][j] && grid[i][j] == '1') {
                        dfs(grid, mark, i, j);
                        // bfs
                        // bfs(grid, mark, i, j);
                        result++;
                    }
                }
            }
            return result;
        }

        private void dfs(char[][] grid, boolean[][] mark, int x, int y) {
            // 方向数组 对应上下左右
            final int[] dx = {-1, 1, 0, 0};
            final int[] dy = {0, 0, -1, 1};
            mark[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                // 超过边界，就搜索下一个
                if (newX < 0 || newX >= mark.length || newY < 0 || newY >= mark[newX].length) {
                    continue;
                }
                // 如果没访问，且是陆地
                if (grid[newX][newY] == '1' && !mark[newX][newY]) {
                    dfs(grid, mark, newX, newY);
                }
            }
        }

        private void bfs(char[][] grid, boolean[][] mark, int x, int y) {
            // 方向数组 对应上下左右
            final int[] dx = {-1, 1, 0, 0};
            final int[] dy = {0, 0, -1, 1};

            mark[x][y] = true;
            Queue<Integer> queue = new LinkedList<>();
            // x和y成对扔进去
            queue.offer(x);
            queue.offer(y);
            while (!queue.isEmpty()) {
                int tempX = queue.poll();
                int tempY = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int newX = tempX + dx[i];
                    int newY = tempY + dy[i];
                    // 超过边界，就搜索下一个
                    if (newX < 0 || newX >= mark.length || newY < 0 || newY >= mark[newX].length) {
                        continue;
                    }
                    // 如果没访问，且是陆地
                    if (grid[newX][newY] == '1' && !mark[newX][newY]) {
                        mark[newX][newY] = true;
                        queue.offer(newX);
                        queue.offer(newY);
                    }
                }
            }

        }

        /**
         * 在原grid 上操作
         * @param grid
         * @return
         */
        public int numIslands1(char[][] grid) {
            int result = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == '1') {
                        dfs(grid, i, j);
                        result++;
                    }
                }
            }
            return result;
        }

        private void dfs(char[][] grid, int x, int y) {
            // 方向数组 对应上下左右
            final int[] dx = {-1, 1, 0, 0};
            final int[] dy = {0, 0, -1, 1};

            grid[x][y] = '0';
            for(int i = 0; i < 4; i++){
                int newX = x + dx[i];
                int newY = y + dy[i];
                if(newX < 0 || newX >= grid.length || newY < 0 || newY >= grid[x].length){
                    continue;
                }
                if(grid[newX][newY] == '1'){
                    dfs(grid, newX, newY);
                }
            }
        }

    }
}
/*
给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，
并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。

示例 1:

输入:
11110
11010
11000
00000

输出: 1
示例 2:

输入:
11000
11000
00100
00011

输出: 3
 */