package zhaoyin;

import java.util.Scanner;

/**
 * Class Main3 ...
 *
 * @author LiJun
 * Created on 2019/4/9
 */
public class Main3 {

    public static void main(String[] args) {
        int max = 100005;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[max];
        int[] visited = new int[2 * max];
        int[] a = new int[2 * max];
        int maxSize = 0;
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
            maxSize = Math.max(maxSize, array[i]);
        }
        for (int i = 0; i < n; i++) {
            int t1 = array[i], t2 = array[i];
            int s1 = 0, s2 = 0;
            visited[t1]++;
            while (t1 <= maxSize) {
                t1 <<= 1;
                visited[t1]++;
                s1++;
                a[t1] += s1;
            }
            while (t2 > 0) {
                if (t2 % 2 == 1 && t2 != 1) {
                    t2 >>= 1;
                    s2++;
                    visited[t2]++;
                    a[t2] += s2;
                    int temp3 = t2;
                    int step3 = s2;
                    while (temp3 <= maxSize) {
                        temp3 <<= 1;
                        visited[temp3]++;
                        step3++;
                        a[temp3] += step3;
                    }
                } else {
                    t2 >>= 1;
                    s2++;
                    visited[t2]++;
                    a[t2] += s2;
                }
            }
        }
        int result = 1 << 30;
        for (int i = 0; i < 2 * maxSize; i++) {
            if (visited[i] == n) {
                result = Math.min(result, a[i]);
            }
        }
        System.out.println(result);
    }
}
