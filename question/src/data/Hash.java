package data;

/**
 * Class Hash ...
 *
 * @author LiJun
 * Created on 2019/5/3
 */
public class Hash {
    private static final int DEFAULT_LENGTH = 16;
    public ListNode[] table;
    public int len;

    public Hash(int len) {
        this.len = len;
        table = new ListNode[len];
    }

    public Hash() {
        this(DEFAULT_LENGTH);
    }

    /**
     * 整数哈希函数，直接取余
     *
     * @param key
     * @return
     */
    private int getHash(int key) {
        return key % len;
    }

    /**
     * 链地址法解决哈希冲突
     *
     * @param node
     */
    public void insert(ListNode node) {
        int hash = getHash(node.val);
        // 采用头插法插入节点
        node.next = table[hash];
        table[hash] = node;
    }

    public boolean search(int val) {
        int hash = getHash(val);
        ListNode head = table[hash];
        while (head != null) {
            if (head.val == val) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
    public void print() {
        for (int i = 0; i < table.length; i++) {
            System.out.print("[" + i + "] : ");
            ListNode p = table[i];
            while (p != null) {
                System.out.print(p.val + "->");
                p = p.next;
            }
            System.out.println("null");
        }
    }
}
