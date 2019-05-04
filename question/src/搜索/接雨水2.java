package 搜索;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Class 接雨水2 ...
 *
 * @author LiJun
 * Created on 2019/5/3
 */
public class 接雨水2 {
    class Solution {
        public int trapRainWater(int[][] heightMap) {
            PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return o2.h - o1.h;
                }
            });
            // 行数和列数小于3的，肯定无法积水
            if (heightMap.length < 3 || heightMap[0].length < 3) {
                return 0;
            }
            int row = heightMap.length;
            int col = heightMap[0].length;
            int[][] mark = new int[row][col];
            // 把四周的点，全部放到队列里面
            for (int i = 0; i < row; i++) {
                queue.offer(new Node(i, 0, heightMap[i][0]));
                mark[i][0] = 1;
                queue.offer(new Node(i, col - 1, heightMap[i][col - 1]));
                mark[i][col - 1] = 1;
            }
            for (int i = 1; i < col - 1; i++) {
                queue.offer(new Node(0, i, heightMap[0][i]));
                mark[0][i] = 1;
                queue.offer(new Node(row - 1, i, heightMap[row - 1][i]));
                mark[row - 1][i] = 1;
            }
            // 方向数组
            final int[] dx = {-1, 1, 0, 0};
            final int[] dy = {0, 0, -1, 1};
            int result = 0;
            while (!queue.isEmpty()) {
                Node temp = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int newX = temp.x + dx[i];
                    int newY = temp.y + dy[i];
                    if (newX < 0 || newX >= row ||
                            newY < 0 || newY >= col) {
                        continue;
                    }
                    if (temp.h > heightMap[newX][newY]) {
                        result += temp.h - heightMap[newX][newY];
                        heightMap[newX][newY] = temp.h;
                    }
                    queue.offer(new Node(newX, newY, heightMap[newX][newY]));
                    mark[newX][newY] = 1;
                }
            }
            return result;
        }

        private class Node {
            int x, y, h;

            public Node(int x, int y, int h) {
                this.x = x;
                this.y = y;
                this.h = h;
            }
        }
    }

}
/*
给定一个 m x n 的矩阵，其中的值均为正整数，代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。



说明:

m 和 n 都是小于110的整数。每一个单位的高度都大于0 且小于 20000。



示例：

给出如下 3x6 的高度图:
[
  [1,4,3,1,3,2],
  [3,2,1,3,2,4],
  [2,3,3,2,3,1]
]

返回 4。


如上图所示，这是下雨前的高度图[[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]] 的状态。





下雨后，雨水将会被存储在这些方块中。总的接雨水量是4。
 */