import java.util.Scanner;

/**
 * Class day.day02_快速判断一个数是不是2的幂 ...
 *
 * @author LiJun
 * Created on 2018/12/17
 */

// 怎么最快判断一个数是不是2的幂

public class day02_快速判断一个数是不是2的幂 {
    /**
     * 判断一个数是不是4的幂
     */
    public void test1() {
        Scanner scanner = new Scanner(System.in);
        int n;
        while (true) {
            n = scanner.nextInt();
            if (((n & (n - 1)) == 0) && ((n & 0x55555555) == n)) {
                System.out.println(n + " yes");
            } else {
                System.out.println(n + " no");
            }
        }
    }

    public void test2() {
        Scanner scanner = new Scanner(System.in);
        int n;
        while (true) {
            n = scanner.nextInt();
            if ((n & (n - 1)) == 0) {
                System.out.println(n + "是2的幂");
            } else {
                System.out.println(n + "不是2的幂");
            }
        }
    }
}
