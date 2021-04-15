package cn.caojiantao.study.node;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * 反转链表
 */
public class q206 {

//    public ListNode reverseList(ListNode head) {
//        ListNode node = null, p = head;
//        while (p != null) {
//            ListNode next = p.next;
//            p.next = node;
//            node = p;
//            p = next;
//        }
//        return node;
//    }

    public ListNode reverseList(ListNode head) {
        return reverseList(null, head);
    }

    public ListNode reverseList(ListNode n1, ListNode n2) {
        if (n2 == null) return n1;
        ListNode next = n2.next;
        n2.next = n1;
        return reverseList(n2, next);
    }
}
