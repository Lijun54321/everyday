package day;

/**
 * Class day20_字节网络风暴 ...
 *
 * @author LiJun
 * Created on 2019/3/31
 */

import java.util.Scanner;

/**
 * 写一个程序，计算有多少种方案在一个N*M(N,M < 6)的国际象棋棋盘里面放入K只马，
 * 使得这K只马不能互相攻击
 */
public class day20_字节网络风暴 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextByte();
        int result = count(n, m, k);
    }

    private static int factorial(int n) {
        int sum = 1;
        while (n > 0) {
            sum = sum * n--;
        }
        return sum;
    }

    public static int combination(int m, int n) {
        return m <= n ? factorial(n) / (factorial(m) * factorial((n - m))) : 0;
    }

    private static int count(int n, int m, int k) {
        // 如果只有一层
        if (m == 1 && k <= n) {
            return combination(n, k);
        }
        if (n == 1 && k <= m) {
            return combination(m, k);
        }

        int[][] array = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                array[i][j] = 0;
            }
        }
        int[] visit = new int[n * m];
        for (int i = 0; i < k; i++) {

        }
        return 0;
    }
}
