package clone;


import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int k, n, m;
            n = scanner.nextInt();
            m = scanner.nextInt();
            k = scanner.nextInt();
            System.out.println(Count(k, n, m));
        }
    }

    public static int Count(int k, int rows, int cols) {
        boolean[] array = new boolean[rows * cols];
        return test(k, rows, cols, 0, 0, array);
    }

    public static int test(int k, int n, int m, int n1, int n2, boolean[] array) {
        int count = 0;
        if (check(k, n, m, n1, n2, array)) {
            array[n1 * m + n2] = true;
            count = 1 + test(k, n, m, n1 - 1, n2, array)
                    + test(k, n, m, n1, n2 - 1, array)
                    + test(k, n, m, n1 + 1, n2, array)
                    + test(k, n, m, n1, n2 + 1, array);
        }
        return count;
    }

    public static boolean check(int k, int n, int m, int n1, int n2, boolean[] array) {
        if (n1 >= 0 && n1 < n && n2 >= 0 && n2 < m && !array[n1 * m + n2] && result(n1, n2) <= k) {
            return true;
        }
        return false;
    }

    public static int result(int n, int m) {
        int r = 0;
        while (n > 0) {
            r += n % 10;
            n /= 10;
        }
        while (m > 0) {
            r += m % 10;
            m /= 10;
        }
        return r;
    }


}
