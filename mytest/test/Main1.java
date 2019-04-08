import java.util.Arrays;
import java.util.Scanner;

/**
 * Class Main1 ...
 *
 * @author LiJun
 * Created on 2019/4/5
 */
public class Main1 {
    private static int result(int m, int[] array) {
        if (array.length <= 0) {
            return -1;
        }
        Arrays.sort(array);
        if (array[0] < 0) {
            return -1;
        }
        int sum = 0, temp = 0;
        while (sum < m) {
            for (int i = array.length - 1; i >= 0; i--) {
                if (array[i] <= sum + 1) {
                    sum += array[i];
                    temp++;
                    break;
                }
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println(result(m, array));
    }
}
