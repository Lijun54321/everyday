package com;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Class leetcode542 ...
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 * <p>
 * 两个相邻元素间的距离为 1 。
 *
 * @author LiJun
 * Created on 2019/4/7
 */
public class leetcode542 {

    static class node {
        int i;
        int j;

        public node(int i, int j) {
            this.i = i;
            this.j = j;

        }

        @Override
        public String toString() {
            return "node{" +
                    "i=" + i +
                    ", j=" + j +
                    '}';
        }
    }

    static class Solution {
        public int[][] updateMatrix(int[][] matrix) {

            if (matrix == null || (matrix.length == 0 && matrix[0].length == 0)) {
                return matrix;
            }
            LinkedList<node> zeroList = new LinkedList<>();
            LinkedList<node> oneList = new LinkedList<>();
            int n = matrix.length;
            int m = matrix[0].length;
            int[][] len = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (matrix[i][j] == 0) {
                        zeroList.add(new node(i, j));
                    } else {
                        oneList.add(new node(i, j));
                    }
                }
            }
            for (node temp : oneList) {
                int min = Integer.MAX_VALUE;
                for (int i = 0; i < zeroList.size(); i++) {
                    node t = zeroList.get(i);
                    int l = Math.abs(temp.i - t.i) + Math.abs(temp.j - t.j);
                    min = min < l ? min : l;
                    if (min == 1) {
                        break;
                    }
                }
                matrix[temp.i][temp.j] = min;
            }

            return matrix;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };

        int[][] matrix1 = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };

        int[][] matrix2 = {{1, 0, 1, 1, 0, 0, 1, 0, 0, 1},
                {0, 1, 1, 0, 1, 0, 1, 0, 1, 1},
                {0, 0, 1, 0, 1, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 1, 1, 1, 1, 1},
                {0, 1, 0, 1, 1, 0, 0, 0, 0, 1},
                {0, 0, 1, 0, 1, 1, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 0, 1, 1},
                {1, 0, 0, 0, 1, 1, 1, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 1, 0},
                {1, 1, 1, 1, 0, 1, 0, 0, 1, 1}};
        int[][] ints = solution.updateMatrix(matrix2);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(Arrays.toString(ints[i]));
        }

    }
}
