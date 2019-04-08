package sort;

import java.util.Scanner;

/**
 * Class Main ...
 *
 * @author LiJun
 * Created on 2019/3/24
 */
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int result = 0, temp, m, n;
        int[] array = new int[6];
        for (int i = 0; i < 6; i++) {
            array[i] = scanner.nextInt();
        }
        test(array);
    }

    private static void test(int[] array) {
        int result = 0, temp, m, n;
        result += array[5];

        temp = array[0] / 11;
        if (temp >= array[4]) {
            array[0] -= 11 * array[4];
        } else {
            array[0] = 0;
        }
        result += array[4];

        temp = array[1] / 5;
        if (temp >= array[3]) {
            array[1] -= 5 * array[3];
        } else {
            array[0] -= (array[3] * 20 - array[1] * 4);
            if (array[0] < 0) {
                array[0] = 0;
            }
            array[1] = 0;
        }
        result += array[3];

        result += array[2] / 4;
        temp = array[2] % 4;
        if (temp == 0) {
            n = array[1] % 9;
            m = array[1] / 9 + (n == 0 ? 0 : 1);
            if (n > 0) {
                array[0] -= (36 - n * 4);
                if (array[0] < 0) {
                    array[0] = 0;
                }
            }
            n = array[0] / 36 + (array[0] % 36 == 0 ? 0 : 1);
            result += m + n;
        } else if (temp == 1) {
            if (array[1] <= 5) {
                array[0] -= (27 - 4 * array[1]);
            } else {
                array[1] -= 5;
                array[0] -= 7;
                n = array[1] % 9;
                result += array[1] / 9 + (n == 0 ? 0 : 1);
                if (n > 0) {
                    array[0] -= (36 - n * 4);
                }
            }
            result++;
            if (array[0] > 0) {
                result += (array[0] / 36 + (array[0] % 36 == 0 ? 0 : 1));
            }
        } else if (temp == 2) {
            if (array[1] <= 3) {
                array[0] -= (18 - 4 * array[1]);
            } else {
                array[1] -= 3;
                array[0] -= 6;
                n = array[1] % 9;
                result += array[1] / 9 + (n == 0 ? 0 : 1);
                if (n > 0) {
                    array[0] -= (36 - n * 4);
                }
            }
            result++;
            if (array[0] > 0) {
                result += (array[0] / 36 + (array[0] % 36 == 0 ? 0 : 1));
            }
        } else if (temp == 3) {
            if (array[1] <= 1) {
                array[0] -= (18 - 4 * array[1]);
            } else {
                array[1] -= 1;
                array[0] -= 5;
                n = array[1] % 9;
                result += array[1] / 9 + (n == 0 ? 0 : 1);
                if (n > 0) {
                    array[0] -= (36 - n * 4);
                }
            }
            result++;
            if (array[0] > 0) {
                result += (array[0] / 36 + (array[0] % 36 == 0 ? 0 : 1));
            }
        }
        System.out.println(result);
    }
}
