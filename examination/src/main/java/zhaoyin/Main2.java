package zhaoyin;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Class Main2 ...
 *
 * @author LiJun
 * Created on 2019/4/9
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 处理输入数据
        int n = scanner.nextInt();
        int w = scanner.nextInt();
        int[] a = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            a[i] = scanner.nextInt();
        }
        getMl(a, n, w);
    }

    private strictfp static void getMl(int[] a, int n, int w) {
        // 排序 小杯子给女生，大杯子给男生
        Arrays.sort(a);
        double max = 0, min = 0, result;

        Arrays.sort(a);
        max = a[n];
        min = a[0];
        if (max > 2 * min) result = 3 * n * min;
        else result = 1.5 * n * max;

        if (result > w) result = w;

        System.out.println(String.format("%.6f", result));
    }
/*
    private strictfp static double getMl(int[] a, int n, int w) {
        double result = 0;
        // 特殊情况
        if (a[0] * 3 * n <= w && a[n] >= a[0] * 2) {
            return (double) a[0] * 3 * n;
        }
        if (a[0] * 3 * n <= w && a[n] < a[0] * 2) {
            return ((double) a[n] / 2) * 3 * n;
        }

        if (a[0] * 3 * n > w && a[n] >= a[0] * 2) {

            return (double) w / (3 * n) * 3 * n;
        }

        if (a[0] * 3 * n > w && a[n] < a[0] * 2) {
            if ((a[n] / 2)

            return (double) w / (3 * n) * 3 * n;
        }

        return 0;


    }*/

}
