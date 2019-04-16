package day;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Class 二叉搜索树转换成双向链表 ...
 * 输入一棵二叉搜索树，
 * 将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *
 * @author LiJun
 * Created on 2019/4/16
 */
public class 二叉搜索树转换成双向链表 {
    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public class Solution {
        public TreeNode Convert(TreeNode pRootOfTree) {
            if(pRootOfTree == null){
                return null;
            }
            List<TreeNode> treeNodes = inorderTraversal(pRootOfTree);
            TreeNode root = treeNodes.remove(0);
            TreeNode p =root;
            p.left = null;
            p.right = null;
            while(!treeNodes.isEmpty()){
                TreeNode t = treeNodes.remove(0);
                p.right = t;
                t.left = p;
                t.right = null;
                p = t;
            }
            return root;
        }
        public TreeNode Convert1(TreeNode pRootOfTree) {
            if(pRootOfTree == null){
                return null;
            }
            List<TreeNode> treeNodes = new LinkedList<>();
            inorderTraversal(pRootOfTree, treeNodes);
            TreeNode root = treeNodes.remove(0);
            TreeNode p =root;
            p.left = null;
            p.right = null;
            while(!treeNodes.isEmpty()){
                TreeNode t = treeNodes.remove(0);
                p.right = t;
                t.left = p;
                t.right = null;
                p = t;
            }
            return root;
        }
        private void inorderTraversal(TreeNode root, List<TreeNode> list) {
            if(root != null){
                inorderTraversal(root.left, list);
                list.add(root);
                inorderTraversal(root.right, list);
            }
        }
        public List<TreeNode> inorderTraversal(TreeNode root) {
            if (root == null) {
                return null;
            }
            List<TreeNode> list = new ArrayList<>();
            Stack<TreeNode> s = new Stack<>();
            do {
                while (root != null) {
                    s.push(root);
                    root = root.left;
                }
                if (!s.isEmpty()) {
                    TreeNode node = s.pop();
                    list.add(node);
                    root = node.right;
                }
            } while (!s.isEmpty() || root != null);
            return list;
        }
    }

}
