package cn.caojiantao.study.leetcode.node;

/**
 * https://leetcode-cn.com/problems/copy-list-with-random-pointer/
 * 复制带随机指针的链表
 */
public class q138 {

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node p = head;
        while (p != null) {
            Node next = p.next;
            Node copy = new Node(p.val);
            copy.next = next;
            p.next = copy;
            p = next;
        }
        p = head;
        while (p != null) {
            if (p.random != null) p.next.random = p.random.next;
            p = p.next.next;
        }
        Node newHead = head.next;
        p = head;
        while (p.next != null) {
            Node next = p.next;
            p.next = p.next.next;
            p = next;
        }
        return newHead;
    }
}
