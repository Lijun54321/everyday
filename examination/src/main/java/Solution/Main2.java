package Solution;

import java.util.Scanner;

/**
 * Class Solution.Main2 ...
 *
 * @author LiJun
 * Created on 2019/3/16
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] str;
        sc.nextLine();
        for (int k = 0; k < n; k++) {

            str = sc.nextLine().toCharArray();
            int len = str.length;
            for (int i = 0; i < len - 2; i++) {
                if (str[i] == str[i + 1] && str[i + 1] == str[i + 2]) {
                    for (int j = i + 1; j < len - 1; j++) {
                        str[j] = str[j + 1];
                    }
                    len--;
                    i--;
                }
            }
            for (int i = 0; i < len - 3; i++) {
                if (str[i] == str[i + 1] && str[i + 2] == str[i + 3]) {
                    for (int j = i + 2; j < len - 1; j++) {
                        str[j] = str[j + 1];
                    }
                    len--;
                    i--;
                }
            }
            for (int i = 0; i < len; i++) {
                System.out.print(str[i]);
            }
            System.out.println();
        }
    }
}