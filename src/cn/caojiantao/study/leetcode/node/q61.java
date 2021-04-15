package cn.caojiantao.study.leetcode.node;

/**
 * https://leetcode-cn.com/problems/rotate-list/
 * 旋转链表
 */
public class q61 {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int n = 1;
        ListNode p = head;
        while (p.next != null) {
            n++;
            p = p.next;
        }
        p.next = head;
        k = n - (k % n + 1);
        p = head;
        while (k-- > 0) p = p.next;
        ListNode newHead = p.next;
        p.next = null;
        return newHead;
    }
}
