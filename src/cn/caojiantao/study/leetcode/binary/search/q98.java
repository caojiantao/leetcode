package cn.caojiantao.study.leetcode.binary.search;

/**
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 * 验证二叉搜索树
 */
public class q98 {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;
        if ((min == null || node.val > min) && (max == null || node.val < max)) {
            return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
        }
        return false;
    }

    private long pre = Long.MIN_VALUE;

    /**
     * 中序遍历
     */
    public boolean isValidBSTV2(TreeNode root) {
        if (root == null) return true;
        if (!isValidBSTV2(root.left)) return false;
        if (root.val <= pre) return false;
        pre = root.val;
        return isValidBSTV2(root.right);
    }
}
