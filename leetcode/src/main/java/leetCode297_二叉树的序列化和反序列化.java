import data.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Class leetCode297_二叉树的序列化和反序列化 ...
 *
 * @author LiJun
 * Created on 2019/5/2
 */
public class leetCode297_二叉树的序列化和反序列化 {
    public class Codec {

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
}
/*
序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。

请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。

示例:

你可以将以下二叉树：

    1
   / \
  2   3
     / \
    4   5

序列化为 "[1,2,3,null,null,4,5]"
提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 */