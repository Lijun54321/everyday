package day;

import day.data.TreeNode;

/**
 * Class 判断一颗树是不是平衡二叉树 ...
 *
 * @author LiJun
 * Created on 2019/4/25
 */
public class 判断一颗树是不是平衡二叉树 {
    static class Solution {
        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }
            int left = help(root.left);
            int right = help(root.right);
            return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }

        public int help(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftHeight = help(root.left);
            int rightHeight = help(root.right);
            return Math.max(leftHeight, rightHeight) + 1;

        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        System.out.println(solution.isBalanced(root));
    }
}
