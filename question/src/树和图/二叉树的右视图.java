package 树和图;

import data.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Class 二叉树的右视图 ...
 *
 * @author LiJun
 * Created on 2019/5/2
 */
public class 二叉树的右视图 {
    static class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            List<Integer> result = new ArrayList<>();
            if (root != null) {
                queue.offer(root);
            }
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size ; i++) {
                    TreeNode temp = queue.poll();
                    if(i == size -1){
                        result.add(temp.val);
                    }
                    if(temp.left != null){
                        queue.offer(temp.left);
                    }
                    if(temp.right != null){
                        queue.offer(temp.right);
                    }
                }
            }
            return result;
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.rightSideView(TreeNode.getTree(null)));
    }
}
