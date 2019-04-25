package day;

import java.util.Scanner;

/**
 * Class 删掉字符变成回文数 ...
 *
 * @author LiJun
 * Created on 2019/4/25
 */
public class 删掉字符变成回文数 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            System.out.println(s.getResult(sc.nextLine()));
        }
        sc.close();
    }


    static class Solution {
        public int getResult(String s) {
            StringBuilder s1 = new StringBuilder(s);
            StringBuilder s2 = new StringBuilder(s).reverse();
            return s.length() - LCS(s1, s2);
        }

        public int LCS(StringBuilder s1, StringBuilder s2) {
            int m = s1.length();
            int n = s2.length();
            int[][] mutrix = new int[m + 1][n + 1];

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        mutrix[i][j] = mutrix[i - 1][j - 1] + 1;
                    } else {
                        mutrix[i][j] = Math.max(mutrix[i - 1][j], mutrix[i][j - 1]);
                    }
                }
            }
            return mutrix[m][n];
        }
    }
}
