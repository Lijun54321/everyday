package test360;

import java.util.Scanner;

/**
 * Class Test1 ...
 *
 * @author LiJun
 * Created on 2019/4/3
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] array = new int[N];
        int min = 0;
        for (int i = 0; i < N; i++) {
            array[i] = scanner.nextInt();
            min += Math.abs(array[i] - i - 1);
        }
        for (int i = 1; i < N; i++) {
            int t = getMin(i, array, min);
            min = min < t ? min : t;
        }
        System.out.println(min);
    }

    private static int getMin(int index, int[] array, int result) {
        int p = index;
        while (p == index - 1) {
            if (array[p] >= 0) result--;
            if (array[p] < 0) result++;
            p++;
            if (p == array.length) {
                p = 0;
            }
        }
        return result;

    }
}
