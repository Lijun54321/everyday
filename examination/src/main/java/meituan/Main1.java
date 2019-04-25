package meituan;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Class Main1 ...
 *
 * @author LiJun
 * Created on 2019/4/23
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        HashMap<Integer, Integer> map0 = new HashMap<>(16);
        HashMap<Integer, Integer> map1 = new HashMap<>(16);
        int t = 0;
        int k0 = 0, k1 = 0;
        int temp, t0 = 1, t1 = 1, t2 = 0, t3 = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                temp = scanner.nextInt();
                int num;
                if (t == 0) {
                    if (map0.containsKey(temp)) {
                        num = map0.get(temp);
                        map0.put(temp, num + 1);
                        if (t0 < num + 1) {
                            t0 = num + 1;
                            k0 = temp;
                        } else if (t1 < num + 1) {
                            t1 = num + 1;
                        }
                    } else {
                        map0.put(temp, 1);
                    }
                    t++;
                } else {
                    if (map1.containsKey(temp)) {
                        num = map1.get(temp);
                        map1.put(temp, num + 1);
                        if (t2 < num + 1) {
                            t2 = num + 1;
                            k1 = temp;
                        } else if (t3 < num + 1) {
                            t3 = num + 1;
                        }
                    } else {
                        map1.put(temp, 1);
                    }
                    t--;
                }
            }
        }
        if (k0 != k1) {
            System.out.println(n * m - t0 - t2);
        } else {
            if (t1 + t2 < t3 + t0) {
                System.out.println(n * m - t0 - t3);
            } else {
                System.out.println(n * m - t1 - t2);
            }
        }
    }
}
