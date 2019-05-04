package 贪心;

import java.util.Arrays;

/**
 * Class 分发饼干 ...
 *
 * @author LiJun
 * Created on 2019/4/25
 */
public class 分发饼干 {
    static class Solution {
        public int findContentChildren(int[] g, int[] s) {
            Arrays.sort(g);
            Arrays.sort(s);
            int cookie = 0;
            int child = 0;
            while (cookie < s.length && child < g.length) {
                if (g[child] <= s[cookie]) {
                    child++;
                }
                cookie++;
            }
            return child;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] g = {5, 10, 2, 9, 15, 9};
        int[] s = {6, 1, 20, 3, 8};
        System.out.println(solution.findContentChildren(g, s));
    }
}
