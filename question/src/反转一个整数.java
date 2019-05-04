/**
 * Class 反转一个整数 ...
 *
 * @author LiJun
 * Created on 2019/4/25
 */
public class 反转一个整数 {
    class Solution {
        public int reverse(int x) {
            StringBuilder sb = new StringBuilder(String.valueOf(Math.abs(x)));
            sb.reverse();
            if (x < 0) {
                sb.insert(0, '-');
            }

            try {
                return Integer.parseInt(sb.toString());
            } catch (Exception e) {
                return 0;
            }
        }
    }
}
