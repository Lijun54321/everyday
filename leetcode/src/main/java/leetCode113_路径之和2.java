import data.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Class leetCode113_路径之和2 ...
 *
 * @author LiJun
 * Created on 2019/5/1
 */
public class leetCode113_路径之和2 {
    static class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> pathSum = new ArrayList<>();
            Stack<Integer> stack = new Stack<>();
            preOrder(root, sum, 0, stack, pathSum);
            return pathSum;
        }

        private void preOrder(TreeNode root, int sum, int pathValue,
                              Stack<Integer> stack,
                              List<List<Integer>> pathSum) {
            if (root != null) {
                stack.push(root.val);
                if (root.left == null && root.right == null && pathValue + root.val == sum) {
                    pathSum.add(new ArrayList<>(stack));
                }
                preOrder(root.left, sum, pathValue + root.val , stack, pathSum);
                preOrder(root.right, sum, pathValue + root.val, stack, pathSum);

                stack.pop();
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        List<List<Integer>> lists = solution.pathSum(root, 22);
        for(List<Integer> l : lists){
            System.out.println(l);
        }
    }
}
/*
给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。

说明: 叶子节点是指没有子节点的节点。

示例:
给定如下二叉树，以及目标和 sum = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
返回:

[
   [5,4,11,2],
   [5,8,4,5]
]
 */