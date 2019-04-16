package day;


import java.util.Scanner;

/**
 * Class 大于一个数的最小回文串 ...
 *
 * @author LiJun
 * Created on 2019/4/13
 */
public class 大于一个数的最小回文串 {
    public static String getResult(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        int c = s.charAt(0) - '0';
        System.out.println(c);
        if (s.length() == 0 && c < 9) {
            c++;
            return c + "";
        } else {
            int num = s.charAt(0) - '0';
            if (s.length() % 2 == 0) {
                for (int i = 1; i < s.length() / 2; i++) {
                    num = num * 10 + (s.charAt(i) - '0');
                }
            } else {
                for (int i = 1; i < s.length() / 2 + 1; i++) {
                    num = num * 10 + (s.charAt(i) - '0');
                }
            }
            for (int i = 0; i < s.length() / 2; i++) {
                if (s.charAt(i) < s.charAt(s.length() - 1 - i)) {
                    num++;
                    break;
                }
            }
            StringBuilder str = new StringBuilder();
            str.append(num + "");
            StringBuilder t = new StringBuilder();
            if ((num + "").length() % 2 == 0) {
                t.append(num + "");
            } else {
                t.append(((num / 10) + ""));
            }
            t.reverse();
            str.append(t);
            return str.toString();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println(getResult(scanner.nextLine()));
        }
    }

}

