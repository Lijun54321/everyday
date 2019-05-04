package duxiaoman;

import java.util.Scanner;

/**
 * Class Main1 ...
 *
 * @author LiJun
 * Created on 2019/4/28
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] nums = new String[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextLine();
        }
        for (int i = 0; i < n; i++) {
            long num = Long.parseLong(nums[i]);
            int count = 0;
            for (int j = 0; j < nums[i].length(); j++) {
                if (nums[i].charAt(j) == '0' || num % (nums[i].charAt(j) - '0') == 0) {
                    count++;
                }
            }
            if (num == 0) {
                System.out.println("G");
            } else if (count == nums[i].length()) {
                System.out.println("G");
            } else if (count == 0) {
                System.out.println("S");
            } else {
                System.out.println("H");
            }
        }
    }
}
