package day;

/**
 * Class 序列化和反序列话一颗二叉树 ...
 *
 * @author LiJun
 * Created on 2019/4/16
 */
public class 序列化和反序列话一颗二叉树 {
    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public class Solution {
        String Serialize(TreeNode root) {
            StringBuilder stringBuilder = new StringBuilder();
            preOrderSerialize(root, stringBuilder);
            return stringBuilder.toString();
        }

        private void preOrderSerialize(TreeNode root, StringBuilder stringBuilder) {
            if (root == null) {
                stringBuilder.append("#!");
            } else {
                stringBuilder.append(root.val + "!");
                preOrderSerialize(root.left, stringBuilder);
                preOrderSerialize(root.right, stringBuilder);
            }
        }

        TreeNode Deserialize(String str) {
            if (str == null || str.length() <= 0) {
                return null;
            }
            String[] split = str.split("!");
            return preOrderDeserialize(split);
        }

        int index = -1;

        private TreeNode preOrderDeserialize(String[] str) {
            if (!"#".equals(str[index])) {
                TreeNode root = new TreeNode(Integer.parseInt(str[index]));
                root.left = preOrderDeserialize(str);
                root.right = preOrderDeserialize(str);
                return root;
            }
            return null;
        }
    }


}
