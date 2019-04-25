package qianxin;

import java.util.Scanner;


/**
 * Class Main2 ...
 *
 * @author LiJun
 * Created on 2019/4/24
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ball = new int[n];
        int max = 0;
        int temp = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            temp = in.nextInt();
            ball[temp]++;
            max = max < temp ? temp : max;
        }
        for (int i = 0; i <= max; i++) {
            res = getResult(res, ball[i]);
        }
        System.out.println(res == 1 ? 0 : n / res);

    }

    private static int getResult(int m, int n) {
        if (m == 0) {
            return n;
        }
        if (n == 0) {
            return m;
        }
        if (m < n) {
            int temp = m;
            m = n;
            n = temp;
        }
        while (m % n != 0) {
            int temp = m % n;
            m = n;
            n = temp;
        }
        return n;
    }
}
