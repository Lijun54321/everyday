package 二分查找和二叉排序树;

import data.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Class 二叉树的编码与解码_层序 ...
 *
 * @author LiJun
 * Created on 2019/5/2
 */
public class 二叉树的编码与解码_层序 {
    public static class Codec {

        public String serialize(TreeNode root) {
            StringBuilder str = new StringBuilder();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode temp = queue.poll();
                if (temp == null) {
                    str.append("#!");
                } else {
                    str.append(temp.val).append("!");
                    queue.offer(temp.left);
                    queue.offer(temp.right);
                }
            }
            return str.toString();
        }

        public TreeNode deserialize(String data) {
            if (data == null || data.length() <= 0) {
                return null;
            }
            List<TreeNode> nodes = new ArrayList<>();
            String[] nums = data.split("!");
            for (int i = 0; i < nums.length; i++) {
                if ("#".equals(nums[i])) {
                    nodes.add(null);
                } else {
                    nodes.add(new TreeNode(Integer.parseInt(nums[i])));
                }
            }
            int j = 1;
            for (int i = 0; j < nums.length; i++) {
                if (nodes.get(i) != null) {
                    nodes.get(i).left = nodes.get(j++);
                    nodes.get(i).right = nodes.get(j++);
                }
            }
            return nodes.get(0);
        }
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode tree = TreeNode.getTree(null);
        System.out.println(codec.serialize(tree));
    }
}
