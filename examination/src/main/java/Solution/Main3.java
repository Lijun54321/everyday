package Solution;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] length = new int[100000];
        // 记录绳子长度
        for (int i = 0; i < n; i++) {
            length[i] = sc.nextInt() * 100;
        }
    }
}