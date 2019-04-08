package Solution;

import java.util.Scanner;

/**
 * Class Solution.Main4 ...
 *
 * @author LiJun
 * Created on 2019/3/16
 */
public class Main4 {
    // 记录测试数据和 需要绳子长度
    private static int n, m;

    private static double sum;
    // 用浮点数组存取绳子的长度
    private static double[] len = new double[100005];

    private static boolean check(double mid) {
        int i, test = 0;
        for (i = 0; i < n; i++) {
            test += (int) (len[i] / mid);
        }
        if (test >= m) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int i;
        double mid, q, p;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        sum = 0;
        for (i = 0; i < n; i++) {
            len[i] = scanner.nextInt();
            sum += len[i];
        }
        sum /= m;
        p = sum;
        q = 0;
        while (p - q > 0.00005) {
            mid = (q + p) / 2;
            if (check(mid)) {
                q = mid;
            } else {
                p = mid;
            }
        }
        System.out.printf("%.2f\n", q);
    }

}
