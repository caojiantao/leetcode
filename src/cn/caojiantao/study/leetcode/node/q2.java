package cn.caojiantao.study.leetcode.node;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 * 两数相加
 */
public class q2 {

    public static void main(String[] args) {
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode();
        ListNode p = sentinel;
        int flag = 0;
        while (l1 != null || l2 != null || flag != 0) {
            int sum = flag;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            ListNode node = new ListNode(sum % 10);
            p.next = node;
            p = node;
            flag = sum < 10 ? 0 : 1;
        }
        return sentinel.next;
    }
}
