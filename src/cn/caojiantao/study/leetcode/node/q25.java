package cn.caojiantao.study.leetcode.node;

/**
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 * K 个一组翻转链表
 */
public class q25 {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        q25 q25 = new q25();
        q25.reverseKGroupV2(node, 1);
    }

    /**
     * 多指针操作
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode sentinel = new ListNode(-1, head);
        ListNode lastTail = sentinel;
        ListNode i = head, j = i;
        int len = k;
        while (j != null) {
            while (j != null && k > 0) {
                j = j.next;
                k--;
            }
            if (k > 0) break;
            ListNode p = j;
            while (i != j) {
                ListNode next = i.next;
                i.next = p;
                p = i;
                i = next;
            }
            ListNode tmp = lastTail.next;
            lastTail.next = p;
            lastTail = tmp;
            k = len;
        }
        return sentinel.next;
    }

    /**
     * 递归设置
     */
    public ListNode reverseKGroupV2(ListNode head, int k) {
        ListNode tail = head;
        int n = k;
        while (tail != null && k > 0) {
            tail = tail.next;
            k--;
        }
        if (k > 0) return head;
        ListNode newHead = reverseListNode(head, tail);
        head.next = reverseKGroupV2(tail, n);
        return newHead;
    }

    private ListNode reverseListNode(ListNode head, ListNode tail) {
        ListNode node = tail;
        while (head != tail) {
            ListNode next = head.next;
            head.next = node;
            node = head;
            head = next;
        }
        return node;
    }
}
