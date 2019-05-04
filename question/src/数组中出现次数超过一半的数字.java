import java.util.Arrays;
import java.util.HashMap;

/**
 * Class 数组中出现次数超过一半的数字 ...
 *
 * @author LiJun
 * Created on 2019/4/16
 */
public class 数组中出现次数超过一半的数字 {
    public static class Solution {
        public int MoreThanHalfNum_Solution(int[] array) {
            Arrays.sort(array);
            int count = 0;
            int mid = array[array.length / 2];
            for (int i = 0; i < array.length; i++) {
                if (mid == array[i]) {
                    count++;
                }
            }
            if (count < array.length / 2) {
                count = 0;
            }
            return count;
        }

        public int MoreThanHalfNum_Solution2(int[] array) {
            HashMap<String, Integer> count = new HashMap<>();
            for (int i = 0; i < array.length; i++) {
                if (count.containsKey(array[i] + "")) {
                    int num = count.get(array[i] + "") + 1;
                    if (num > array.length / 2) {
                        return array[i];
                    }
                    count.put(array[i] + "", num);
                } else {
                    count.put(array[i] + "", 1);
                }
            }
            System.out.println(count);
            return 0;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(solution.MoreThanHalfNum_Solution2(array));
    }

}
