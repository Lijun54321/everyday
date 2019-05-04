package bytes;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Class Main1 ...
 *
 * @author LiJun
 * Created on 2019/4/14
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // n 记录测试用例个数
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            // m 代表有多少帧
            int m = Integer.parseInt(scanner.nextLine());
            // 创建个list 存取每帧的信息
            LinkedList<HashSet<String>> cats = new LinkedList<>();
            // 存取所有的特征
            HashSet<String> vector = new HashSet<>();
            // 处理输入信息，把每帧的数据处理到一个set里面之后放入list
            for (int j = 0; j < m; j++) {
                HashSet<String> temp = new HashSet<>();
                String[] s = scanner.nextLine().split(" ");
                if (s.length > 0) {
                    // 转换成字符串存到set 中，并且把该特征放到所有特征中
                    int t = Integer.parseInt(s[0]);
                    for (int k = 1; k <= t * 2; k = k + 2) {
                        String str = s[k] + "_" + s[k + 1];
                        temp.add(str);
                        vector.add(str);
                    }
                }
                cats.add(temp);
            }
            // 开始计算
            int max = Integer.MIN_VALUE;
            for (String str : vector) {
                // 每次判断一个特征 在所有帧中的出现次数
                int temp = 0;
                int maxNum = Integer.MIN_VALUE;
                for (int q = 0; q < m; q++) {
                    // 因为用的是hashset 这个复杂度是 O(1)
                    if (cats.get(q).contains(str)) {
                        temp++;
                    }else {
                        temp = 0;
                    }
                    // 找出连续帧的最大值
                    maxNum = maxNum > temp ? maxNum : temp;
                }
                // 得出结果
                max = max > maxNum ? max : maxNum;
            }
            System.out.println(max);
        }

    }
}

/*
1
8
2 1 1 2 2
2 1 1 1 4
2 1 1 2 2
2 2 2 1 4
0
0
1 1 1
1 1 1
 */