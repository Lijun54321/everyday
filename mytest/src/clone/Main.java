package clone;

import java.util.Arrays;
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
        String string = scanner.nextLine();

        if ("None".equals(string)) {
            System.out.println("True");
        } else {
            String[] nums = string.split(",");
            long[] arrays = new long[nums.length];

            for (int i = 0; i < nums.length; i++) {
                arrays[i] = Integer.valueOf(nums[i]);
            }
            // System.out.println(Arrays.toString(arrays));
            System.out.println(isSearchTree(arrays));
        }

    }

    private static String isSearchTree(long[] arrays) {
        if (arrays == null || arrays.length == 0) {
            return "True";
        }
        if (arrays.length > 10000) {
            return "False";
        }
        for (int i = 0; i < arrays.length / 2; i++) {
            int t = i * 2 + 1;
            if (t < arrays.length && arrays[i] <= arrays[t]) {
                return "False";
            }
            t = i * 2 + 2;
            if (t < arrays.length && arrays[i] >= arrays[t]) {
                return "False";
            }
            int m = i / 2 - 1;
            t = i * 2 + 2;
            if (m >= 0 && t < arrays.length && arrays[m] <= arrays[t]) {
                return "False";
            }
        }
        return "True";
    }
}
