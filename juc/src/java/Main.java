import java.util.Arrays;

/**
 * Class Main ...
 *
 * @author LiJun
 * Created on 2019/4/11
 */
public class Main {
    public static int[] maxSize(int[] nums) {
        if (nums.length == 0) {
            return new int[]{0, 0};
        }
        int index = 0;
        int max = 0;
        int count = 1;
        int i = 0;
        for (; i < nums.length - 1; i++) {

            if (nums[i] < nums[i + 1]) {
                count++;
            } else {
                if (count > max) {
                    index = i;
                    max = count;
                }
                count = 1;
            }

        }
        if (count > max) {
            index = i;
            max = count;
        }
        return new int[]{index - max + 1, index};
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 2, 3, 1, 2, 3, 4, 5};
        int[] num = {3, 3, 3, 3, 3};
        int[] nu = {1, 2, 3, 5, 4};
        int[] n = {1, 2, 3, 5, 4, 5, 6, 9, 8, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 8};
        System.out.println(Arrays.toString(maxSize(n)));
    }
}