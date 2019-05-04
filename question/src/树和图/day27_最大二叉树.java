package 树和图;


/**
 * Class day27_最大二叉树 ...
 *
 * @author LiJun
 * Created on 2019/4/13
 */
public class day27_最大二叉树 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    class Solution {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            if (nums == null || nums.length == 0) {
                return null;
            }
            // 构造出根节点
            TreeNode root = new TreeNode(nums[0]);
            for (int i = 1; i < nums.length; i++) {
                TreeNode temp = new TreeNode(nums[i]);
                // 如果当前值比根节点大，将根节点设为该节点左孩子，并更新根节点为该节点
                if (nums[i] > root.val) {
                    temp.left = root;
                    root = temp;
                } else {
                    // 找到合适的位置
                    TreeNode t = root;
                    while (t.right != null && t.right.val > temp.val) {
                        t = t.right;
                    }
                    temp.left = t.right;
                    t.right = temp;
                }
            }
            return root;
        }
    }


}
