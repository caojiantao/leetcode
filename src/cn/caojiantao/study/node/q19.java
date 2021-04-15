package cn.caojiantao.study.node;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * 删除链表的倒数第 N 个结点
 */
public class q19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sentinel = new ListNode(-1, head);
        ListNode i = sentinel, j = i;
        while (j != null && n >= 0) {
            j = j.next;
            n--;
        }
        while (j != null) {
            i = i.next;
            j = j.next;
        }
        i.next = i.next.next;
        return sentinel.next;
    }
}
