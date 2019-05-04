package 树和图;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Class 从上往下打印二叉树的每一个节点_同层次的节点从左向右依次打印 ...
 *
 * @author LiJun
 * Created on 2019/4/15
 */
public class 从上往下打印二叉树的每一个节点_同层次的节点从左向右依次打印 {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    class Solution {
        public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
            LinkedList<TreeNode> list = new LinkedList<>();
            ArrayList<Integer> nodes = new ArrayList<>();

            if (root != null) {
                list.offer(root);
            }

            while (!list.isEmpty()) {
                TreeNode t = list.poll();
                nodes.add(t.val);
                if (t.left != null) {
                    list.offer(t.left);
                }
                if (t.right != null) {
                    list.offer(t.right);
                }
            }
            return nodes;
        }
    }
}

