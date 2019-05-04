package duxiaoman;

import java.util.Scanner;

/**
 * Class Main2 ...
 *
 * @author LiJun
 * Created on 2019/4/28
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int i = 0;
        int ans = 0;
        int cnt = 0;
        while (i < n) {
            while (i < n - 1 && nums[i + 1] <= nums[i]) {
                i += 1;
            }
            int min = nums[i];
            i += 1;
            while (i < n - 1 && nums[i + 1] >= nums[i]) {
                i += 1;
            }
            if (i < n) {
                ans += nums[i] - min;
                cnt += 2;
            }
        }

        System.out.println(ans);
        System.out.println(cnt);
    }

}
