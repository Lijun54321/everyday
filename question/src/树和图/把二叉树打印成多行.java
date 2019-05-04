package 树和图;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Class 把二叉树打印成多行 ...
 *
 * @author LiJun
 * Created on 2019/4/16
 */
public class 把二叉树打印成多行 {
    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    public class Solution {
        ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
            LinkedList<TreeNode> queue = new LinkedList<>();
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();
            if(pRoot == null){
                return result;
            }
            queue.offer(pRoot);
            ArrayList<Integer> temp = new ArrayList<>();
            int count = queue.size();
            while(!queue.isEmpty()){
                TreeNode t = queue.poll();
                count --;
                temp.add(t.val);
                if(t.left != null){
                    queue.offer(t.left);
                }
                if(t.right != null){
                    queue.offer(t.right);
                }
                if(count == 0){
                    result.add(temp);
                    temp = new ArrayList<>();
                    count = queue.size();
                }
            }
            return result;
        }
    }


}
