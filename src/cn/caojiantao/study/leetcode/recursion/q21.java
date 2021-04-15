package cn.caojiantao.study.leetcode.recursion;

/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * 合并两个有序链表
 */
public class q21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        boolean flag = l1.val < l2.val;
        ListNode res = flag ? l1 : l2;
        res.next = mergeTwoLists(res.next, flag ? l2 : l1);
        return res;
    }
}
