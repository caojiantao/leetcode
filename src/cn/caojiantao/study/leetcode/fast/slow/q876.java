package cn.caojiantao.study.leetcode.fast.slow;

public class q876 {

    public ListNode middleNode(ListNode head) {
        ListNode i = new ListNode(-1, head), j = i;
        while (j != null && j.next != null) {
            j = j.next.next;
            i = i.next;
        }
        return j == null ? i : i.next;
    }
}
