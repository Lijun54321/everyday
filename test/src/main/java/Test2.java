import java.util.Arrays;
import java.util.Scanner;

/**
 * Class Test2 ...
 *
 * @author LiJun
 * Created on 2019/4/25
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] money = {200, 100, 20, 10, 5, 1};
        while (true) {
            int x = scanner.nextInt();
            int[] num = new int[6];
            int count = 0;
            for (int i = 0; i < 6; i++) {
                num[i] = x / money[i];
                count += num[i];
                x = x % money[i];
            }
            System.out.println(Arrays.toString(num) + " count = " + count);
        }
    }
}
