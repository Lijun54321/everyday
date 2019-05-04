package 二分查找和二叉排序树;

import data.TreeNode;

/**
 * Class 二叉查找数插入节点 ...
 *
 * @author LiJun
 * Created on 2019/5/2
 */
public class 二叉查找数插入节点 {
    public static TreeNode BstTreeInsert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode temp = root;
        while (temp != null) {
            if (temp.val < val) {
                if (temp.right == null) {
                    temp.right = new TreeNode(val);
                    break;
                }
                temp = temp.right;
            } else {
                if (temp.left == null) {
                    temp.left = new TreeNode(val);
                    break;
                }
                temp = temp.left;
            }
        }
        return root;
    }
    public static void print(TreeNode root){
        if(root != null){
            print(root.left);
            System.out.print(root.val + " ");
            print(root.right);
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 8, 7, 2, 0};
        TreeNode root = null;
        for(int i : nums){
            root = BstTreeInsert(root, i);
        }
        print(root);
    }
}
