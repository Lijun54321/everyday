package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Class HuffmanTree ...
 *
 * @author LiJun
 * Created on 2019/4/12
 */
public class HuffmanTree {
    private static class Node {
        String data;
        double weight;
        Node left;
        Node right;

        public Node(String data, double wight) {
            this.data = data;
            this.weight = wight;
        }

        /**
         * todo
         *
         * @param data
         * @param weight
         * @param left
         * @param right
         */
        public Node(String data, double weight, Node left, Node right) {
            this.data = data;
            this.weight = weight;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", weight=" + weight +
                    '}';
        }

        public double getWeight() {
            return weight;
        }
    }

    public static void main(String[] args) {
        List<Node> nodes = new ArrayList<Node>();

        nodes.add(new Node("A", 40.0));
        nodes.add(new Node("B", 8.0));
        nodes.add(new Node("C", 10.0));
        nodes.add(new Node("D", 30.0));
        nodes.add(new Node("E", 10.0));
        nodes.add(new Node("F", 2.0));
        Node root = HuffmanTree.createTree(nodes);
        huffmanPrint(root);
    }

    /**
     * 构建一棵赫夫曼树
     *
     * @param nodes 节点
     * @return 构造出来的根节点
     */
    public static Node createTree(List<Node> nodes) {
        while (nodes.size() > 1) {
            nodes.sort((o1, o2) -> Double.compare(o2.weight, o1.weight));
            System.out.println(nodes);
            Node left = nodes.remove(nodes.size() - 1);
            Node right = nodes.remove(nodes.size() - 1);
            Node t = new Node(null, left.weight + right.weight, left, right);
            nodes.add(t);
        }
        return nodes.get(0);
    }

    public static void huffmanPrint(Node root) {
        if (root == null) {
            return;
        }
        huffmanPrint(root.left);
        if (root.left == null && root.right == null) {
            System.out.print(root);
        }
        huffmanPrint(root.right);

    }

    /**
     * 中序遍历
     */
    public void inOrderPrint(Node root) {
        if (root == null) {
            return;
        }
        inOrderPrint(root.left);
        System.out.print(root);
        inOrderPrint(root.right);
    }

    /**
     * 先序遍历
     */
    public void preOrderPrint(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root);
        inOrderPrint(root.left);
        inOrderPrint(root.right);
    }

    /**
     * 先序遍历
     */
    public void postOrderPrint(Node root) {
        if (root == null) {
            return;
        }
        inOrderPrint(root.left);
        inOrderPrint(root.right);
        System.out.print(root);
    }
}
