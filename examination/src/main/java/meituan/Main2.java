package meituan;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Class Main2 ...
 * 题目描述：
 * 给你一棵含有n个结点的树,编号为0…n-1，这n个结点都被染成了黑色或白色，显然，对于一棵树而言，我们每去掉一条边，就能把树分成两部分。现在要求你把这棵树切开，使得每一个连通块内只有一个白色结点，问共有多少种切开的方式满足以上条件，如果被删除的边集不同，我们则认为两种方式不同，反之认为相同。
 * <p>
 * 请输出方案数对1000000007取模的结果。
 * <p>
 * 参考输入：
 * <p>
 * 10
 * <p>
 * 0 0 1 2 0 5 1 2 3
 * <p>
 * 1 0 0 1 0 0 1 1 0 1
 *
 * @author LiJun
 * Created on 2019/4/23
 */
public class Main2 {
    static class Node {
        int i;
        int color;

        public Node(int i, int color) {
            this.i = i;
            this.color = color;
        }

        @Override
        public String toString() {
            return "{" +
                    "i=" + i +
                    ", color=" + color +
                    '}';
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] node = new int[n];
        for (int i = 1; i < n; i++) {
            node[i] = scanner.nextInt();
        }
        int[] color = new int[n];
        for (int i = 0; i < n; i++) {
            color[i] = scanner.nextInt();
        }
        LinkedList<LinkedList<Node>> lists = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            lists.add(new LinkedList<>());
        }
        LinkedList<Node> nodes = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            Node temp = new Node(i, color[i]);
            nodes.add(temp);
            lists.get(i).add(temp);
        }
        for (int i = 1; i < n; i++) {
            lists.get(node[i]).add(nodes.get(i));
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (lists.get(i).get(0).color == 1) {
                int t = getWhiteNode(lists.get(i));
                res = res == 0 ? 1 : res;
                res = t == 0 ? res : (res * t) % 1000000007;
            }
        }
        System.out.println(res);
    }

    private static int getWhiteNode(LinkedList<Node> nodes) {
        int count = 0;
        for (Node node : nodes) {
            if (node.color == 0) {
                count++;
            }
        }
        return count;
    }
}
/*
10
0 0 1 2 0 5 1 2 3
1 0 0 1 0 0 1 1 0 1
[0, 1, 1, 0, 0, 1, 0, 0, 0, 0]
[0, 0, 0, 1, 0, 0, 0, 1, 0, 0]
[0, 0, 0, 0, 1, 0, 0, 0, 1, 0]
[0, 0, 0, 0, 0, 0, 0, 0, 0, 1]
[0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
[0, 0, 0, 0, 0, 0, 1, 0, 0, 0]
[0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
[0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
[0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
[0, 0, 0, 0, 0, 0, 0, 0, 0, 0]

 */