/**
 * Class day09 ...
 *
 * @author LiJun
 * Created on 2018/12/24
 *
 */
// 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树，
// 假设输入的前序遍历和终须遍历的结果中都不包含重复的数字。
// 例如：
//      前序遍历序列{1, 2, 4, 7, 3, 5, 6, 8};
//      中序遍历序列{4, 7, 2, 1, 5, 3, 8, 6};
public class day09 {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

    }
    public static Node Construct(int[] preOrder, int[] inOrder) {
        // 参数有效性检查
        if (preOrder == null || inOrder == null || preOrder.length <= 0
                || inOrder.length <= 0 || preOrder.length != inOrder.length) {
            return null;
        }
        return ConstructCore(preOrder, 0, preOrder.length - 1,
                inOrder, 0, inOrder.length - 1);
    }

    public static Node ConstructCore(int[] preOrder, int startPre,
                                     int endPre, int[] inOrder, int startIn, int endIn) {
        if (startPre > endPre)
            return null;
        int index;
        for (index = startIn; index <= endIn &&
                inOrder[index] != preOrder[startPre]; index++) ;
        Node root = new Node();
        root.value = preOrder[startPre];
        root.left = ConstructCore(
                preOrder, startPre + 1, startPre + index - startIn,
                inOrder, startIn, index - 1);
        root.right = ConstructCore(preOrder, startPre + index + 1 - startIn,
                endPre, inOrder, index + 1, endIn);
        return root;
    }

    public static void printPre(Node tNode) {
        if (tNode != null) {
            System.out.print(tNode.value + " ");
            printPre(tNode.left);
            printPre(tNode.right);

        }
    }

    public static void printIn(Node tNode) {
        if (tNode != null) {
            printIn(tNode.left);
            System.out.print(tNode.value + " ");
            printIn(tNode.right);

        }
    }


    public static void main(String[] args) {
        int[] preOrder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inOrder = {4, 7, 2, 1, 5, 3, 8, 6};
        Node construct = Construct(preOrder, inOrder);
        printPre(construct);
        System.out.println();
        printIn(construct);
    }
}

