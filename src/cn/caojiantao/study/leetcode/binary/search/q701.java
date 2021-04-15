package cn.caojiantao.study.leetcode.binary.search;

/**
 * https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/
 * 二叉搜索树中的插入操作
 */
public class q701 {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode newNode = new TreeNode(val, null, null);
        if (root == null) return newNode;
        TreeNode left = root.left, right = root.right;
        if (val < root.val) {
            if (left == null) root.left = newNode;
            else insertIntoBST(left, val);
        } else {
            if (right == null) root.right = newNode;
            else insertIntoBST(right, val);
        }
        return root;
    }
}
