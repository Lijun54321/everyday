package 树和图;

import data.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Class 最近的公共祖先 ...
 *
 * @author LiJun
 * Created on 2019/5/1
 */
public class 最近的公共祖先 {
    static class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            Stack<TreeNode> path = new Stack<>();
            List<List<TreeNode>> t = new ArrayList<>();
            preOder(root, p, path, t, false);
            preOder(root, q, path, t, false);

            if (t.size() < 2) {
                return null;
            }

            List<TreeNode> path1 = t.get(0).size() > t.get(1).size() ? t.get(0) : t.get(1);
            List<TreeNode> path2 = t.get(0).size() <= t.get(1).size() ? t.get(0) : t.get(1);
            System.out.println(path1);
            System.out.println(path2);
            int i = 0;
            while (i < path1.size() && i < path2.size()) {
                if (i != 0 && path1.get(i) != path2.get(i)) {
                    return path1.get(i - 1);
                }
                i++;
            }
            if (i >= path2.size()) {
                return path1.get(i - 1);
            }
            return null;
        }

        private void preOder(TreeNode root, TreeNode search,
                             Stack<TreeNode> path, List<List<TreeNode>> t, boolean finish) {
            if (root == null || finish) {
                return;
            }
            path.push(root);
            if (root == search) {
                finish = true;
                t.add(new ArrayList<>(path));
            }
            preOder(root.left, search, path, t, finish);
            preOder(root.right, search, path, t, finish);
            path.pop();
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        System.out.println(solution.lowestCommonAncestor(root, root.left.right.left, root.left));
    }
}
/*
给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]

               3
             /   \
            5     1
           / \   / \
          6   2 0   8
             / \
            7   4

示例 1:

输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
输出: 3
解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
示例 2:

输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
输出: 5
解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。


说明:

所有节点的值都是唯一的。
p、q 为不同节点且均存在于给定的二叉树中。
 */