import java.util.Scanner;

/**
 * Class Main ...
 *
 * @author LiJun
 * Created on 2019/3/30
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();
        int count = 0;
        while (num != 0) {
            count++;
            num = num & (num - 1);
        }
        System.out.println(count);
    }
}
