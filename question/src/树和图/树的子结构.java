package 树和图;

import java.util.LinkedList;

/**
 * Class 树的子结构 ...
 * 输入两棵二叉树A，B，判断B是不是A的子结构。
 * （ps：我们约定空树不是任意一个树的子结构）
 *
 * @author LiJun
 * Created on 2019/4/16
 */
public class 树的子结构 {
    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public class Solution {
        public boolean HasSubtree(TreeNode root1, TreeNode root2) {
            if (root2 == null || (root1 == null && root2 != null)) {
                return false;
            }
            boolean flag = false;
            if (root1.val == root2.val) {
                flag = isSubTree(root1.left, root2);
            }
            if (!flag) {
                flag = HasSubtree(root1.right, root2);
            }
            return flag;

        }

        private boolean isSubTree(TreeNode root1, TreeNode root2) {
            if (root2 == null) {
                return true;
            }
            if (root1 == null && root2 != null) {
                return false;
            }
            if (root1.val == root2.val) {
                return isSubTree(root1.left, root2.left) && isSubTree(root1.right, root2.right);
            } else {
                return false;
            }
        }

        public boolean HasSubtree1(TreeNode root1, TreeNode root2) {
            if (root2 == null || root1 == null) {
                return false;
            }
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.offer(root1);
            while (!queue.isEmpty()) {
                TreeNode t = queue.poll();
                boolean flag = false;
                if (t.val == root2.val) {
                    flag = isChildTree(t, root2);
                }
                if (flag) {
                    return true;
                }
                if (t.left != null) {
                    queue.offer(t.left);
                }
                if (t.right != null) {
                    queue.offer(t.right);
                }
            }
            return false;
        }

        private boolean isChildTree(TreeNode t, TreeNode root2) {
            LinkedList<TreeNode> q1 = new LinkedList<>();
            LinkedList<TreeNode> q2 = new LinkedList<>();
            q1.offer(t);
            q2.offer(root2);
            while (!q1.isEmpty() && !q2.isEmpty()) {
                if (q1.peek().val != q2.peek().val) {
                    return false;
                }
                TreeNode temp = q1.poll();
                if (temp.left != null) {
                    q1.offer(temp.left);
                }
                if (temp.right != null) {
                    q1.offer(temp.right);
                }
                temp = q2.poll();
                if (temp.left != null) {
                    q2.offer(temp.left);
                }
                if (temp.right != null) {
                    q2.offer(temp.right);
                }
            }
            return true;

        }
    }

}
