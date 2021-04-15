package cn.caojiantao.study.tree;

/**
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 * 平衡二叉树
 */
public class q110 {

    /**
     * 自定向下，存在重复计算
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int leftH = getHeight(root.left);
        int rightH = getHeight(root.right);
        if (Math.abs(leftH - rightH) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    /**
     * 获取当前节点树的高度
     */
    private int getHeight(TreeNode node) {
        if (node == null) return 0;
        int leftH = getHeight(node.left);
        int rightH = getHeight(node.right);
        return Math.max(leftH, rightH) + 1;
    }

    public boolean isBalancedV2(TreeNode root) {
        return getHeightV2(root) != -1;
    }

    /**
     * 如果当前节点数平衡，则返回当前节点树的高度，否则返回 -1
     */
    private int getHeightV2(TreeNode node) {
        if (node == null) return 0;
        int leftH = getHeightV2(node.left);
        if (leftH == -1) return -1;
        int rightH = getHeightV2(node.right);
        if (rightH == -1) return -1;
        if (Math.abs(leftH - rightH) > 1) return -1;
        return Math.max(leftH, rightH) + 1;
    }
}
