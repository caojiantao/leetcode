package cn.caojiantao.study.recursion;

/**
 * https://leetcode-cn.com/problems/invert-binary-tree/
 * 翻转二叉树
 */
public class q226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
