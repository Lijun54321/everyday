package Solution;

import java.util.Scanner;

public class Main {
    private static int[] per = new int[100005];
    private static int[][] score = new int[100005][2];
    private static int[] num = new int[100005];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int k = 0; k < n; k++) {
            int person = sc.nextInt();
            // 存取数据
            for (int j = 0; j < person; j++) {
                per[j] = sc.nextInt();
            }
            // 初始化信息
            for (int i = 0; i < person; i++) {
                num[i] = score[i][0] = score[i][1] = -1;
            }
            for (int i = 0; i < person; i++) {
                if (per[(i - 1 + person) % person] > per[i]) {
                    score[i][0] = (i - 1 + person) % person;
                }
                if (per[(i + 1) % person] > per[i]) {
                    score[i][1] = (i + 1) % person;
                }
            }
            for (int i = 0; i < person; i++) {
                fun(i, 1);
            }
            int result = 0;
            for (int i = 0; i < person; i++) {
                result += num[i];
            }
            System.out.println(result);
        }
    }
    private static void fun(int index, int val) {
        if (index == -1) {
            return;
        }
        if (num[index] > val) {
            return;
        } else {
            num[index] = val;
        }
        fun(score[index][0], val + 1);
        fun(score[index][1], val + 1);
    }
}
