package 二分查找和二叉排序树;

import data.TreeNode;

/**
 * Class 二叉查找数编码与解码_前序 ...
 *
 * @author LiJun
 * Created on 2019/5/2
 */
public class 二叉查找数编码与解码_前序 {
    public class Codec {

        public String serialize(TreeNode root) {
            StringBuilder str = new StringBuilder();
            preOrder(root, str);
            return str.toString();
        }

        private void preOrder(TreeNode root, StringBuilder str) {
            if (root == null) {
                str.append("#!");
            } else {
                str.append(root.val).append("!");
                preOrder(root.left, str);
                preOrder(root.right, str);
            }
        }

        public TreeNode deserialize(String data) {
            if (data == null || data.length() <= 0) {
                return null;
            }
            String[] split = data.split("!");
            TreeNode root = null;
            for(int i = 0; i < split.length; i++){
                if(!"#".equals(split[i])){
                    root = bstTreeInsert(root, Integer.parseInt(split[i]));
                }
            }
            return root;

        }
        public TreeNode bstTreeInsert(TreeNode root, int val) {
            if (root == null) {
                return new TreeNode(val);
            }
            TreeNode temp = root;
            while (temp != null) {
                if (temp.val < val) {
                    if (temp.right == null) {
                        temp.right = new TreeNode(val);
                        break;
                    }
                    temp = temp.right;
                } else {
                    if (temp.left == null) {
                        temp.left = new TreeNode(val);
                        break;
                    }
                    temp = temp.left;
                }
            }
            return root;
        }
    }


}
