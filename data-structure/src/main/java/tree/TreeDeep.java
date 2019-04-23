package tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * Class TreeDeep ...
 *
 * @author LiJun
 * Created on 2019/4/4
 */
public class TreeDeep {
    private class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
        @Override
        public String toString() {
            return "TreeNode{" +
                    "value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    "}";
        }
    }

    private TreeNode head;

    /**
     * 迭代创建一棵二叉树
     *
     * @param value 值
     */
    public void insertion(int value) {
        if (head == null) {
            head = new TreeNode(value, null, null);
            return;
        }
        TreeNode p = head;
        while (true) {
            if (value < p.value) {
                if (p.left == null) {
                    p.left = new TreeNode(value, null, null);
                    break;
                }
                p = p.left;
            } else {
                if (p.right == null) {
                    p.right = new TreeNode(value, null, null);
                    break;
                }
                p = p.right;
            }
        }
    }

    /**
     * 迭代创建一棵二叉树
     *
     * @param value 值
     */
    public void insertionByDeep(int value) {
        if (head == null) {
            head = new TreeNode(value, null, null);
        } else {
            deepInsert(value, head);
        }
    }

    private void deepInsert(int value, TreeNode node) {
        if (value < node.value) {
            if (node.left == null) {
                node.left = new TreeNode(value, null, null);
            } else {
                this.deepInsert(value, node.left);
            }

        } else {
            if (node.right == null) {
                node.right = new TreeNode(value, null, null);
            } else {
                this.deepInsert(value, node.right);
            }

        }
    }

    public int getDeepLength() {
        return getMaxDepth(head);
    }

    private int getMaxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = getMaxDepth(node.left);
        int right = getMaxDepth(node.right);
        return 1 + (left > right ? left : right);
    }

    public int getWitdth() {
        return getMaxWitdth(head);
    }

    public int getMaxWitdth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        Scanner scanner  = new Scanner(System.in);
        Queue<TreeNode> queue = new ArrayDeque<>();
        int maxWidth = 1;
        queue.add(node);
        while (true) {
            int len = queue.size();
            if (len == 0) {
                break;
            }
            while (len-- > 0) {

                TreeNode t = queue.poll();

                if (t.left != null) {
                    queue.add(t.left);
                }
                if (t.right != null) {
                    queue.add(t.right);
                }
            }
            maxWidth = maxWidth > queue.size() ? maxWidth : queue.size();
        }

        return maxWidth;
    }

    private void printTree(TreeNode node) {
        if (node == null) {
            return;
        }
        printTree(node.left);
        System.out.print(node.value + " ");
        printTree(node.right);
    }

    public void print() {
        printTree(head);
        System.out.println();
    }

    public static void main(String[] args) {
        TreeDeep treeDeep = new TreeDeep();
        int[] array = {5, 1, 4, 7, 8, 9, 6, 3, 2};
        for (int index : array) {
            System.out.print(index);
            treeDeep.insertion(index);
        }
        System.out.println();

        System.out.println(treeDeep.head.right);

        treeDeep.print();
        System.out.println(treeDeep.getDeepLength());
        System.out.println(treeDeep.getWitdth());
    }
}
