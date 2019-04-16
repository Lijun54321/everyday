package day;

import java.util.Arrays;

/**
 * Class 有效的三角形个数 ...
 *
 * @author LiJun
 * Created on 2019/4/13
 */
public class 有效的三角形个数 {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for(int i = nums.length-1; i >= 2; i--) {
            int l = 0, r = i - 1;
            while (l < r) {
                if (nums[l] + nums[r] > nums[i]) {
                    res += r - l;
                    r--;
                } else {
                    l++;
                }
            }
        }
        return res;
    }
}
