package cn.caojiantao.study.leetcode.recursion;

/**
 * https://leetcode-cn.com/problems/symmetric-tree/
 * 对称二叉树
 */
public class q101 {

    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }

    private boolean isSymmetric(TreeNode m, TreeNode n) {
        if (m == null && n == null) return true;
        if (m == null || n == null || m.val != n.val) return false;
        return isSymmetric(m.left, n.right) && isSymmetric(m.right, n.left);
    }
}
