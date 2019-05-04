import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Class leetCode51_N皇后 ...
 *
 * @author LiJun
 * Created on 2019/5/1
 */
public class leetCode51_N皇后 {
    static class Solution {

        public List<List<String>> solveNQueens(int n) {
            List<List<String>> result = new LinkedList<>();
            // 定义一个n*n的布尔矩阵
            boolean[][] mark = new boolean[n][n];
            // location 表示我们得每一横排的结果 初始化全为 .
            List<String> location = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    stringBuilder.append('.');
                }
                location.add(stringBuilder.toString());
            }
            getResult(0, n, result, location, mark);
            return result;
        }

        private void getResult(int k, int n, List<List<String>> result, List<String> location, boolean[][] mark) {
            if (k == n) {
                // 这里必须new 一下，不然最后结果全为 ... java 实在是烦啊
                result.add(new ArrayList<>(location));
                return;
            }
            for (int i = 0; i < n; i++) {
                if (!mark[k][i]) {
                    // 这里必须深拷贝，java是真的烦
                    boolean[][] tempMark = getTemp(mark);
                    // 取出location list 中对应k位置的字符串
                    StringBuilder str = new StringBuilder(location.get(k));
                    // 将其相应 i 位置改为 Q
                    str.setCharAt(i, 'Q');
                    // 放回去
                    location.set(k, str.toString());
                    // 往该位置放皇后
                    putQueen(k, i, mark);
                    // 继续
                    getResult(k + 1, n, result, location, mark);
                    // 改回去
                    mark = tempMark;
                    str.setCharAt(i, '.');
                    location.set(k, str.toString());
                }
            }
        }
        private void putQueen(int x, int y, boolean[][] mark) {
            mark[x][y] = true;
            /*
            方向数组
            (x-1, y-1)  (x-1, y)    (x-1, y+1)
            (x, y-1)    (x, y)      (x, y+1)
            (x+1, y-1)  (x+1, y)    (x+1, y+1)
            方向分别为 上下左右，左上、右上，左下，右下
             */
            final int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
            final int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
            for (int i = 0; i < mark.length; i++) {
                for (int j = 0; j < 8; j++) {
                    int tempX = x + i * dx[j];
                    int tempY = y + i * dy[j];
                    if (tempX >= 0 && tempX < mark.length
                            && tempY >= 0 && tempY < mark[0].length) {
                        mark[tempX][tempY] = true;
                    }
                }
            }
        }

        private boolean[][] getTemp(boolean[][] mark) {
            boolean[][] temp = new boolean[mark.length][mark[0].length];
            for (int i = 0; i < mark.length; i++) {
                for (int j = 0; j < mark.length; j++) {
                    temp[i][j] = mark[i][j];
                }
            }
            return temp;
        }


        public List<List<String>> solveNQueens1(int n) {
            List<List<String>> result = new LinkedList<>();
            int[] mark = new int[n];
            generate(0, n, result, mark);

            return result;
        }

        private void generate(int k, int n,
                              List<List<String>> result, int[] mark) {
            if (k == n) {
                List<String> list = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    StringBuilder str = getLocation(n);
                    str.setCharAt(mark[i], 'Q');
                    list.add(str.toString());
                }
                result.add(list);
                return;
            }
            for (int i = 0; i < n; i++) {
                mark[k] = i;
                if (valid(k, mark)) {
                    generate(k + 1, n, result, mark);
                }
            }
        }

        private StringBuilder getLocation(int n) {
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < n; i++) {
                str.append(".");
            }
            return str;
        }

        private boolean valid(int k, int[] mark) {
            for (int i = 0; i < k; i++) {
                if (mark[i] == mark[k] || k - i == Math.abs(mark[k] - mark[i])) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (List<String> t : solution.solveNQueens(4)) {
            for (String s : t) {
                System.out.println(s);
            }
            System.out.println("----------");
        }
    }
}
/*
n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，
并且使皇后彼此之间不能相互攻击。



上图为 8 皇后问题的一种解法。

给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。

每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该
方案中 'Q' 和 '.' 分别代表了皇后和空位。

示例:

输入: 4
输出: [
 [".Q..",  // 解法 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // 解法 2
  "Q...",
  "...Q",
  ".Q.."]
]
解释: 4 皇后问题存在两个不同的解法。
 */