package tree;


import lombok.Getter;

/**
 * Class tree.RedBlackTree ...
 *
 * @author LiJun
 * Created on 2019/3/29
 */
public class RedBlackTree {
    // 红黑色着色
    private static final boolean RED = false;
    private static final boolean BLACK = true;

    private static final class TreeNode {
        int value;
        TreeNode parent;
        TreeNode left;
        TreeNode right;
        boolean color = BLACK;

        public TreeNode(int value, TreeNode parent) {
            this.value = value;
            this.parent = parent;
            this.left = this.right = null;
        }

        @Override
        public String toString() {
            return "value = " + value + " " + "color = " + (color == RED ? "red" : "block");
        }
    }

    @Getter
    private TreeNode root;
    /**
     * The number of nodes
     */
    private int size = 0;

    // 默认采用无参的构造方法

    /**
     * put
     *
     * @param value the value is what we want to insert
     */
    public boolean put(int value) {

        TreeNode t = root;
        // 如果根节点为空，初始化根节点的内容
        if (t == null) {
            root = new TreeNode(value, null);
            size = 1;
            return true;
        }
        // 如果根节点不为空
        TreeNode parent = null;
        while (t != null) {
            // 记录当前节点
            parent = t;
            if (t.value < value) {
                // 如果当前遍历的节点小于我们要插入的值，向右走
                t = t.right;
            } else if (t.value > value) {
                // 如果当前遍历的节点大于我们要插入的值，向左走
                t = t.left;
            } else {
                // 不允许插入同样的值
                return false;
            }
        }
        // 到这的时候，我们已经找到了改插入的位置了，t=null
        // 我们也记录了相应的parent位置
        // 这个时候的话，先创建一个节点吧,并将其着色为红
        TreeNode node = new TreeNode(value, parent);
        node.color = RED;
        // 这里判断下应该放在左，还是放在右
        if (parent.value > value) {
            parent.left = node;
        } else {
            parent.right = node;
        }
        // 节点数加一
        size++;
        // 对树进行调整，使得满足红黑树特性
        fixAfterInsertion(node);
        return true;
    }

    /**
     * 当我们插入一个节点后，可能已经破坏了红黑树的特性
     * 这个时候我们需要重新调整树，使得满足红黑树特性
     *
     * @param node 节点
     */
    private void fixAfterInsertion(TreeNode node) {
        // 获取当前节点的父节点
        TreeNode parent = node.parent;
        // 如果父节点不为空，且颜色为红色
        while ((parent != null) && (RED == parent.color)) {
            // 获取祖父节点
            TreeNode grandfather = parent.parent;
            // 如果是左孩子
            if (parent == grandfather.left) {
                TreeNode uncle = grandfather.right;
                // uncle 存在为红
                if ((uncle != null) && (uncle.color == RED)) {
                    // 这里将父节点和叔节点设置为黑色
                    parent.color = BLACK;
                    uncle.color = BLACK;
                    // 将祖父节点设置为红色
                    grandfather.color = RED;
                    // 将祖父节点设置为当前节点
                    node = grandfather;
                    parent = node.parent;
                } else {// uncle不存在或者为黑节点
                    if (node == parent.right) {
                        rotateLeft(parent);
                        TreeNode temp = parent;
                        node = parent;
                        parent = node;
                    }
                    // 将父节点设为黑色
                    // 将祖父节点设为红色
                    // 对祖父节点进行右旋
                    rotateRight(grandfather);
                    parent.color = BLACK;
                    grandfather.color = RED;
                }
            } else { // parent == grandfather.right，这里的处理和上面的大致一样
                TreeNode uncle = grandfather.left;
                // uncle 存在为红
                if ((uncle != null) && (uncle.color == RED)) {
                    parent.color = BLACK;
                    uncle.color = BLACK;
                    grandfather.color = RED;

                    node = grandfather;
                    parent = node.parent;
                } else {// uncle不存在或者为黑节点
                    if (node == parent.right) {
                        rotateRight(parent);
                        TreeNode temp = parent;
                        node = parent;
                        parent = node;
                    }
                    rotateLeft(grandfather);
                    parent.color = BLACK;
                    grandfather.color = RED;
                }
            }
        }
        root.color = BLACK;
    }

    /**
     * 右旋
     *
     * @param p 节点
     */
    private void rotateRight(TreeNode p) {
        if (p != null) {
            TreeNode l = p.left;
            p.left = l.right;
            if (l.right != null) {
                l.right.parent = p;
            }
            l.parent = p.parent;
            if (p.parent == null) {
                root = l;
            } else if (p.parent.right == p) {
                p.parent.right = l;
            } else {
                p.parent.left = l;
            }
            l.right = p;
            p.parent = l;
        }
    }

    /**
     * 左旋
     *
     * @param p node
     */
    private void rotateLeft(TreeNode p) {
        if (p != null) {
            TreeNode r = p.right;
            p.right = r.left;
            if (r.left != null) {
                r.left.parent = p;
            }
            r.parent = p.parent;
            if (p.parent == null) {
                root = r;
            } else if (p.parent.left == p) {
                p.parent.left = r;
            } else {
                p.parent.right = r;
            }
            r.left = p;
            p.parent = r;
        }
    }

    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();
        // 通过数组构造一颗树
        int[] array = {80, 40, 120, 20, 60, 100, 140, 10, 50, 90, 10, 30};
        for (int i = 0; i < array.length; i++) {
            tree.put(array[i]);
        }

        tree.preOrder(tree.getRoot());
        System.out.println("-----------------------------");
        tree.inOrder(tree.getRoot());
        // 得到的结果如下

        /*
value = 80 color = block
value = 40 color = red
value = 20 color = block
value = 10 color = red
value = 30 color = red
value = 60 color = block
value = 50 color = red
value = 120 color = red
value = 100 color = block
value = 90 color = red
value = 140 color = block
-----------------------------
value = 10 color = red
value = 20 color = block
value = 30 color = red
value = 40 color = red
value = 50 color = red
value = 60 color = block
value = 80 color = block
value = 90 color = red
value = 100 color = block
value = 120 color = red
value = 140 color = block
*/

    }


    /**
     * 在这里我将三种遍历都写出来了，我们稍后通过遍历构造出树，看是不是我们需要的
     *
     * @param node
     */
    public void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node);
        inOrder(node.right);

    }

    public void afterOrfer(TreeNode node) {
        if (node == null) {
            return;
        }
        afterOrfer(node.left);
        afterOrfer(node.right);
        System.out.println(node);
    }


}

