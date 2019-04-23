package xiecheng;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Class Main3 ...
 *
 * @author LiJun
 * Created on 2019/4/8
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < k; i++) {
            String str = scanner.next();
            if (str.substring(str.length() - 1)
                    .equals("/")) {
                str = str.substring(1, str.length() - 1);
            } else {
                str = str.substring(1);
            }
            if (hashMap.containsKey(str)) {
                int n = hashMap.get(str) + 1;
                hashMap.put(str, n);
                System.out.print("1");
                for (int j = 1;
                     j < str.split("/").length - 1;
                     j++) {
                    System.out.print(n + "");
                }
                System.out.print("1");
            } else {
                hashMap.put(str, 1);
                for (int j = 0;
                     j < str.split("/").length;
                     j++) {
                    System.out.print("1");
                }
            }
            if (i != k - 1) {
                System.out.print(" ");
            } else {
                System.out.println();
            }
        }
    }
}
