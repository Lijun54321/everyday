package bytes;

import java.util.Arrays;

/**
 * Class Main2 ...
 *
 * @author LiJun
 * Created on 2019/4/14
 */
public class Main2 {
    public static void main(String[] args) {
        Integer[] nums = new Integer[]{1, 2, 3, 5, 7, 98, 6, 0};
        int[] nums2 = {1, 2, 3, 5, 7, 98, 6, 0};
        Arrays.sort(nums, (a, b) -> b - a);

        System.out.println(Arrays.toString(nums));

    }
}
