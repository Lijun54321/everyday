import java.util.Scanner;

/**
 *
 * @author LiJun
 */
// 机器人的运动范围
public class day14_机器人的运动范围 {

    private static int movingCount(int threshold, int rows, int cols) {
        // 参数有效性检查
        if (threshold < 0 || rows <= 0 || cols <= 0) {
            return 0;
        }
        boolean[] visited = new boolean[rows * cols];
        for (int i = 0; i < rows * cols; i++) {
            visited[i] = false;
        }
        return movingCountCore(threshold, rows, cols, 0, 0, visited);
    }

    private static int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        int count = 0;
        if (check(threshold, rows, cols, row, col, visited)) {
            visited[row * cols + col] = true;
            count = 1 + movingCountCore(threshold, rows, cols, row - 1, col, visited)
                    + movingCountCore(threshold, rows, cols, row, col - 1, visited)
                    + movingCountCore(threshold, rows, cols, row + 1, col, visited)
                    + movingCountCore(threshold, rows, cols, row, col + 1, visited);
        }
        return count;
    }

    private static boolean check(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        if (row >= 0 && row < rows && col >= 0 && col < cols && !visited[row * cols + col] && getSum(row, col) <= threshold) {
            return true;
        }
        return false;
    }

    private static int getSum(int row, int col) {
        int sum = 0;
        while (row > 0) {
            sum += row % 10;
            row /= 10;
        }
        while (col > 0) {
            sum += col % 10;
            col /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int k, n,m;
            n = scanner.nextInt();
            m = scanner.nextInt();
            k = scanner.nextInt();
            System.out.println(movingCount(k, n, m));
        }

    }

}
