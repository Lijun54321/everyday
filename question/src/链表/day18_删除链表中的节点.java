package 链表;

/**
 * Class day.链表.day18_删除链表中的节点 ...
 *
 * @author LiJun
 * Created on 2019/1/22
 */
public class day18_删除链表中的节点 {

    private static class ListNode{
        int m_nValue;
         ListNode next;

        public ListNode() {
            this.next = null;
        }

        @Override
        protected void finalize() {
            try {
                super.finalize();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }

    private static void deleteNode(ListNode listHead, ListNode pToDeleted){
        if(pToDeleted == null || listHead == null){
            return;
        }
        // 先判断要删除的节点是不是尾节点，如果不是就删除节点
        if(pToDeleted.next != null){
            pToDeleted.m_nValue = pToDeleted.next.m_nValue;
            pToDeleted.next = pToDeleted.next.next;
        }
        // 判断链表中的节点是不是只有一个
        else if(listHead == pToDeleted){
            listHead = pToDeleted = null;
        }
        // 链表中有多个节点，删除尾节点
        else {
            ListNode pNode = listHead;
            while(pNode.next != pToDeleted){
                pNode = pNode.next;
            }
            pNode.next = null;
        }
    }
    private static void print(ListNode node){
        while(node != null){
            System.out.print(node.m_nValue + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode();
        ListNode node2 = new ListNode();
        ListNode node3 = new ListNode();
        ListNode node4 = new ListNode();
        ListNode node5 = new ListNode();
        ListNode node6 = new ListNode();
        ListNode node7 = new ListNode();
        ListNode node8 = new ListNode();
        node1.m_nValue = 1;node1.next = node2;
        node2.m_nValue = 2;node2.next = node3;
        node3.m_nValue = 3;node3.next = node4;
        node4.m_nValue = 4;node4.next = node5;
        node5.m_nValue = 5;node5.next = node6;
        node6.m_nValue = 6;node6.next = node7;
        node7.m_nValue = 7;node7.next = node8;
        node8.m_nValue = 8;
        print(node1);
        // 删除头结点
        deleteNode(node1, node1);
        print(node1);
        // 删除中间节点
        deleteNode(node1, node3);
        print(node1);
        // 删除尾节点
        deleteNode(node1,node8);
        print(node1);
        // 只有一个节点且删除 目前不成立

        ListNode node9 = new ListNode();
        node9.m_nValue = 9;
        deleteNode(node9, node9);

        print(node9);
    }
}
