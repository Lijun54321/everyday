package day;

/**
 * Class day.day15_剪绳子_动规 ...
 *
 * @author LiJun
 * Created on 2019/1/2
 */

public class day15_剪绳子_动规 {

    public static int maxProductAfterCutting_solution(int length) {
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }
        int[] products = new int[length + 1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;
        int max = 0;
        for (int i = 4; i <= length; i++) {
            max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int product = products[j] * products[i - j];
                if (max < product) {
                    max = product;
                }
                products[i] = max;
            }
        }
        return products[length];

    }

    public static void main(String[] args) {
        System.out.println(maxProductAfterCutting_solution(8));


    }
}
