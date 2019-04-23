package jd;

import java.util.*;

/**
 * Class Main2 ...
 *
 * @author LiJun
 * Created on 2019/4/13
 */
public class Main2 {
    private static long count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<String> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.next());
        }
        String target = scanner.next();
        getResult(list, target, 0);
        System.out.println(count);
    }

    private static void getResult(List<String> list, String s, long t) {
        list.removeIf(sss -> !s.contains(sss));
        if (list.size() != 0) {
            for (int i = 0; i < list.size(); i++) {
                getResult(list, s.replaceFirst(list.get(i), "#"), t + 1);
            }
        } else if (t > count) {
            count = t;
        }
    }
}

class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = Integer.parseInt(scanner.nextLine());
        String[] strings = new String[m];
        for (int i = 0; i < m; i++) {
            strings[i] = scanner.nextLine();
        }
        String target = scanner.nextLine();
        System.out.println(getResult(strings, target));
    }

    private static int getResult(String[] strings, String target) {

        if (strings == null || strings.length == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < strings.length; i++) {
            boolean[] visited = new boolean[strings.length];
            int t = dfs(strings[i], target);
        }
        return 0;
    }

    private static int dfs(String string, String target) {
        return 0;
    }

}
