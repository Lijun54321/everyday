package test360;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Class test ...
 *
 * @author LiJun
 * Created on 2019/4/3
 */
public class test {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Integer[] arrays = new Integer[n];
        for (int i = 0; i < n; i++) {
            arrays[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            int t = sc.nextInt();
            int x = sc.nextInt();
            Arrays.sort(arrays, 0, x, t == 1
                    ? (Comparator<Integer>) (a, b) -> b - a
                    : (Comparator<Integer>) (a, b) -> a - b);
        }

        for (Integer num : arrays) {
            System.out.print(num + " ");
        }
    }
}
