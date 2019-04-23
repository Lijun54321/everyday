package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Class TreeIterator ...
 *
 * @author LiJun
 * Created on 2019/4/16
 */
public class TreeIterator {
    /**
     * 前序遍历 根左右
     * 基础思想就是利用栈，先将根节点入栈
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> list = new ArrayList<Integer>();

        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);

        while (!s.isEmpty()) {
            TreeNode node = s.pop();
            list.add(node.val);
            if (node.right != null) {
                s.push(node.right);
            }
            if (node.left != null) {
                s.push(node.left);
            }
        }
        return list;
    }

    /**
     * 中序遍历 左根右
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        do {
            while (root != null) {
                s.push(root);
                root = root.left;
            }
            if (!s.isEmpty()) {
                TreeNode node = s.pop();
                list.add(node.val);
                root = node.right;
            }
        } while (!s.isEmpty() || root != null);
        return list;
    }

    /**
     * 后序遍历 左右跟
     */
    public static List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> list = new ArrayList<Integer>();

        Stack<TreeNode> s = new Stack<TreeNode>();

        s.push(root);

        while (!s.isEmpty()) {
            TreeNode node = s.pop();
            if (node.left != null) {
                s.push(node.left);
            }

            if (node.right != null) {
                s.push(node.right);
            }

            list.add(0, node.val);
        }

        return list;
    }

    /**
     * 树节点
     */
    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
}
