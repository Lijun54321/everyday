package 树和图;

import data.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Class 二叉树层次遍历 ...
 *
 * @author LiJun
 * Created on 2019/5/2
 */
public class 二叉树层次遍历 {

    public static void BFSTree(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        if(root !=null ) {
            queue.offer(root);
        }
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            System.out.print(temp + " ");
            if(temp.left != null){
                queue.offer(temp.left);
            }
            if(temp.right != null){
                queue.offer(temp.right);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String[] nums = {
                "1",
                "2", "3",
                "4","5", "6", "7",
                null, null, "10", null, "12", "13", "14", "15", "16",
                null, null, null, null, "21", null, null, null, "25"
        };
        TreeNode root = TreeNode.getTree(nums);

        BFSTree(root);
    }
}
