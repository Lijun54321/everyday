/**
 * Class day.day13_矩阵中的路径 ...
 *
 * @author LiJun
 * Created on 2018/12/28
 */
// 矩阵中的路径
public class day13_矩阵中的路径 {
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || rows < 1 || cols < 1 || str == null) {
            return false;
        }
        boolean[] visited = new boolean[rows * cols];
        /*// java中 boolean的默认初值是false 所以可有可无
        for(int i = 0; i < rows*cols; i++){
            visited[i] = false;
        }
        */
        int pathLength = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (hasPathCore(matrix, rows, cols, row, col, str, pathLength, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean hasPathCore(char[] matrix, int rows, int cols,
                                       int row, int col, char[] str, int pathLength, boolean[] visited) {
        if (pathLength == str.length) {
            return true;
        }
        boolean hasPath = false;
        // 保证数据的有效性 且没被访问过
        if (row >= 0 && row < rows && col >= 0 && col < cols
                && matrix[row * cols + col] == str[pathLength] &&
                !visited[row * cols + col]) {
            pathLength++;
            visited[row * cols + col] = true;
            hasPath = hasPathCore(matrix, rows, cols, row, col - 1, str, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row - 1, col, str, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row, col + 1, str, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row + 1, col, str, pathLength, visited);
            if (!hasPath) {
                --pathLength;
                visited[row * cols + col] = false;
            }
        }
        return hasPath;
    }

    public static void main(String[] args) {
        String s = "abtgcfcsjdeh";
        char[] matrix = s.toCharArray();
        char[] str = {'a','b','f','b'};
        System.out.println(hasPath(matrix, 3, 4, str));
        str = new char[]{'b','f','c','e'};
        System.out.println(hasPath(matrix, 3, 4, str));
    }

}
