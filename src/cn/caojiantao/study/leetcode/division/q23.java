package cn.caojiantao.study.leetcode.division;

/**
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 * 合并K个排序链表
 */
public class q23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return mergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if (start == end) return lists[start];
        int mid = (start + end) / 2;
        ListNode left = mergeKLists(lists, start, mid);
        ListNode right = mergeKLists(lists, mid + 1, end);
        return mergeTwoListNode(left, right);
    }

    private ListNode mergeTwoListNode(ListNode m, ListNode n) {
        if (m == null) return n;
        if (n == null) return m;
        boolean flag = m.val < n.val;
        ListNode res = flag ? m : n;
        res.next = mergeTwoListNode(res.next, flag ? n : m);
        return res;
    }
}
