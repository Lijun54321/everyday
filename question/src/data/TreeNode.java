package data;

import java.util.ArrayList;
import java.util.List;

/**
 * Class TreeNode ...
 *
 * @author LiJun
 * Created on 2019/4/16
 */
public class TreeNode {
    public int val = 0;
    public TreeNode left = null;
    public TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
    public static final String[] nums = {
            "1",
            "2", "3",
            "4","5", "6", "7",
            null, null, "10", "11"
    };

    public static final TreeNode root = TreeNode.getTree(nums);

    public static TreeNode getTree(String[] nums) {
        if (nums == null || nums.length <= 0) {
            return root;
        }
        List<TreeNode> nodes = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == null) {
                nodes.add(null);
            } else {
                nodes.add(new TreeNode(Integer.parseInt(nums[i])));
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int left = (i << 1) + 1;
            int right = (i << 1) + 2;
            if (nodes.get(i) != null) {
                nodes.get(i).left = left >= nums.length ? null : nodes.get(left);
                nodes.get(i).right = right >= nums.length ? null : nodes.get(right);
            }
        }
        return nodes.get(0);
    }


    @Override
    public String toString() {
        return val + " ";
    }
}