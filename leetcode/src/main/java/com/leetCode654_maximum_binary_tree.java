package com;

import com.data.TreeNode;

/**
 * Class leetCode654_maximum_binary_tree ...
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 *
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 *
 * @author LiJun
 * Created on 2019/4/23
 */
public class leetCode654_maximum_binary_tree {
    class Solution {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            if (nums == null || nums.length == 0) {
                return null;
            }
            TreeNode root = new TreeNode(nums[0]);
            for (int i = 1; i < nums.length; i++) {
                TreeNode temp = new TreeNode(nums[i]);
                if(nums[i] > root.val){
                    temp.left = root;
                    root = temp;
                }else{
                    TreeNode t = root;
                    while(t.right != null && t.right.val > temp.val){
                        t = t.right;
                    }
                    temp.left =t.right;
                    t.right = temp;
                }
            }
            return root;
        }
    }
}
