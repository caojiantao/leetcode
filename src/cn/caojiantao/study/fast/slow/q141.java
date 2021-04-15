package cn.caojiantao.study.fast.slow;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * 环形链表
 */
public class q141 {

    public boolean hasCycle(ListNode head) {
        ListNode i = new ListNode(-1, head), j = i;
        do {
            j = j.next;
            if (j == null) break;
            j = j.next;
            if (j == null) break;
            i = i.next;
        } while (j != i);
        return j == i;
    }
}
