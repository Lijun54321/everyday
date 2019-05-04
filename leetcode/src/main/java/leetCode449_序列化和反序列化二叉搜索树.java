import data.TreeNode;

/**
 * Class leetCode449_序列化和反序列化二叉搜索树 ...
 *
 * @author LiJun
 * Created on 2019/5/2
 */
public class leetCode449_序列化和反序列化二叉搜索树 {
    public class Codec {
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
            index++;
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
/*
序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。

设计一个算法来序列化和反序列化二叉搜索树。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。

编码的字符串应尽可能紧凑。
 */