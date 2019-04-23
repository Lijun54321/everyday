package zhaoyin;

import java.util.Scanner;

/**
 * Class Main1 ...
 *
 * @author LiJun
 * Created on 2019/4/9
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(getAns(n));
    }

    private static int getAns(int n) {
        if (n < 6) return 0;
        if (n == 6) return 1;
        int count = 1;
        for (int i = 0; i < n - 6; i++) {
            count = (count * 2) % 666666666;
        }
        return count;
    }

}
