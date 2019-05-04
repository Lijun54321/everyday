import data.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Class leetCode114_二叉树转链表 ...
 *
 * @author LiJun
 * Created on 2019/5/2
 */
public class leetCode114_二叉树转链表 {
    class Solution {
        public void flatten(TreeNode root) {
            if (root == null) {
                return;
            }
            if (root.left != null) {
                flatten(root.left);
            }
            if (root.right != null) {
                flatten(root.right);
            }
            if (root.left != null) {
                TreeNode tmp = root.left;
                while (tmp.right != null) {
                    tmp = tmp.right;
                }
                tmp.right = root.right;
                root.right = root.left;
                root.left = null;
            }
        }
        public void flatten1(TreeNode root) {
            List<TreeNode> temp = new ArrayList<>();
            preOrder(root, temp);
            for (int i = 1; i < temp.size(); i++) {
                temp.get(i - 1).left = null;
                temp.get(i - 1).right = temp.get(i);
            }
        }

        private void preOrder(TreeNode root, List<TreeNode> temp) {
            if (root != null) {
                temp.add(root);
                preOrder(root.left, temp);
                preOrder(root.right, temp);
            }
        }
    }
}

/*
给定一个二叉树，原地将它展开为链表。

例如，给定二叉树

    1
   / \
  2   5
 / \   \
3   4   6
将其展开为：

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
 */