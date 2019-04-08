import java.util.Scanner;

/**
 * Class Main2 ...
 *
 * @author LiJun
 * Created on 2019/4/5
 */
public class Main2 {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String string = scanner.nextLine();
            int n = Integer.valueOf(string);
            char[] chars = scanner.nextLine().toCharArray();
            getNum(chars);
            int a = 0, b = 0;
            for (char c : chars) {
                if (c == '0') {
                    ++a;
                } else {
                    ++b;
                }
            }
            System.out.println(n - 2 * (a < b ? a : b));
    }

    private static void getNum(char[] chars) {
        String string = String.copyValueOf(chars);
        while (string.contains("01")) {
            string = string.replace("01", "");
        }
        while (string.contains("10")) {
            string = string.replace("10", "");
        }
        System.out.println("a = " + string.length());

    }
}
