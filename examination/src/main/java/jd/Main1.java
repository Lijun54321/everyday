package jd;

import java.util.*;

/**
 * Class Main1 ...
 *
 * @author LiJun
 * Created on 2019/4/13
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<List<Integer>> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> node = new LinkedList<>();
            list.add(node);
        }
        for (int i = 0; i < n - 1; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if (x < y) {
                List<Integer> node = list.get(x - 1);
                node.add(y - 1);
            } else {
                List<Integer> node = list.get(y - 1);
                node.add(x - 1);
            }
        }

        System.out.println(getResult(list));
    }

    // 6 2 1 3 2 4 3 5 2 6 1
    private static int getResult(List<List<Integer>> list) {
        if (list == null || list.size() <= 0) {
            return 0;
        }
        int count = 0;
        List<Integer> root = list.get(0);
        while (root.size() > 0) {
            count++;
            int size = root.size();
            Iterator<Integer> iterator = root.iterator();
            while (iterator.hasNext()) {
                Integer next = iterator.next();
                List<Integer> temp = list.get(next);
                if (temp.size() <= 0) {
                    iterator.remove();
                } else {
                    while (temp.size() > 0) {
                        List<Integer> mNode = list.get(temp.get(0));
                        if (mNode.size() <= 0) {
                            temp.remove(0);
                        }
                        temp = mNode;
                    }
                }
            }
        }
        return count;
    }
}
