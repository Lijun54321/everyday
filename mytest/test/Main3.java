import java.util.Scanner;

/**
 * Class Main3 ...
 *
 * @author LiJun
 * Created on 2019/4/5
 */
public class Main3 {
    private static int[][] data;
    private static int n;
    private static long result = Integer.MAX_VALUE;

    private static void dfs(int a, int res, long t) {
        if (a == n) {
            if (res < result) {
                result = res;
            }
            return;
        }
        if(t < data[0][ a]){
            dfs(a + 1, res + data[1][a], t + data[0][a]);
        } else {
            dfs(a + 1, res, t);
            dfs(a + 1, res + data[1][a], t + data[0][a]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        data = new int[2][n];
        for (int i = 0; i < 2; i++) {
            for(int j = 0; j < n;j++) {
                data[i][j] = scanner.nextInt();
            }
        }
        dfs(0, 0, 0);
        System.out.println(result);
    }
}

/*

import java.util.Scanner;

public class Main {
    private static int[] d;
    private static int[] p;
    private static int n;
    private static int result = Integer.MAX_VALUE;

    private static void dfs(int a, int res, long t) {
        if (a == n) {
            if (res < result) {
                result = res;
            }
            return;
        }
        if (t < d[a]) {
            dfs(a + 1, res + p[a], t + d[a]);
        } else {
            dfs(a + 1, res, t);
            dfs(a + 1, res + p[a], t + d[a]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        d = new int[n];
        p = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            p[i] = scanner.nextInt();
        }
        dfs(0, 0, 0);
        System.out.println(result);
    }
}
*/