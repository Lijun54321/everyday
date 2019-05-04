package 树和图;

/**
 * Class day.树和图.day10_二叉树的下一个节点 ...
 *
 * @author LiJun
 * Created on 2018/12/25
 */

// 二叉树的下一个节点
public class day10_二叉树的下一个节点 {
    public static class BinaryTreeNode {
        public char value;
        public BinaryTreeNode left;
        public BinaryTreeNode right;
        public BinaryTreeNode parent;

        public BinaryTreeNode(char value) {
            this.value = value;
        }

        public BinaryTreeNode() {
        }
    }

    public static BinaryTreeNode nextNode(BinaryTreeNode tree) {
        // 参数有效性检查
        if (tree == null) {
            return null;
        }
        BinaryTreeNode next = null;
        if (tree.right != null) {
            next = tree.right;
            while (next.left != null) {
                next = next.left;
            }
        } else if (tree.parent != null) {

            while(tree.parent != null && tree == tree.parent.right){
                tree = tree.parent;
            }
            next = tree.parent;

        }
        return next;
    }

    public static void print(BinaryTreeNode node) {
        if (node != null) {
            print(node.left);
            System.out.print(node.value);
            print(node.right);
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode a = new BinaryTreeNode('a');
        BinaryTreeNode b = new BinaryTreeNode('b');
        BinaryTreeNode c = new BinaryTreeNode('c');
        BinaryTreeNode d = new BinaryTreeNode('d');
        BinaryTreeNode e = new BinaryTreeNode('e');
        BinaryTreeNode f = new BinaryTreeNode('f');
        BinaryTreeNode g = new BinaryTreeNode('g');
        BinaryTreeNode h = new BinaryTreeNode('h');
        BinaryTreeNode i = new BinaryTreeNode('i');
        a.left = b;     a.right = c;    a.parent = null;
        b.left = d;     b.right = e;    b.parent = a;
        c.left = f;     c.right = g;    c.parent = a;
        d.left = null;  d.right = null; d.parent = b;
        e.left = h;     e.right = i;    e.parent = b;
        f.left = null;  f.right = null; f.parent = c;
        g.left = null;  g.right = null; g.parent = c;
        h.left = null;  h.right = null; h.parent = e;
        i.left = null;  i.right = null; i.parent = e;

        System.out.println(nextNode(a) != null ? nextNode(a) : "null");
        System.out.println(nextNode(b) != null ? nextNode(b) : "null");
        System.out.println(nextNode(c) != null ? nextNode(c) : "null");
        System.out.println(nextNode(d) != null ? nextNode(d) : "null");
        System.out.println(nextNode(e) != null ? nextNode(e) : "null");
        System.out.println(nextNode(f) != null ? nextNode(f) : "null");
        System.out.println(nextNode(g) != null ? nextNode(g) : "null");
        System.out.println(nextNode(h) != null ? nextNode(h) : "null");
        System.out.println(nextNode(i) != null ? nextNode(i
        ) : "null");
    }

}
