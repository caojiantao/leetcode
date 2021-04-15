package cn.caojiantao.study.binary.search;

/**
 * https://leetcode-cn.com/problems/delete-node-in-a-bst/
 * 删除二叉搜索树中的节点
 */
public class q450 {

    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode sentinel = new TreeNode(-1, root, null);
        boolean flag = true;
        TreeNode node = root, pre = sentinel;
        while (node != null) {
            if (key == node.val) break;
            pre = node;
            flag = key < node.val;
            node = flag ? node.left : node.right;
        }
        if (node == null) return root;
        TreeNode left = node.left, right = node.right;
        TreeNode sentinelTmp = new TreeNode(-1, right, null);
        TreeNode sentinelTmp_p = sentinelTmp;
        while (sentinelTmp_p.left != null) sentinelTmp_p = sentinelTmp_p.left;
        sentinelTmp_p.left = left;
        if (flag) {
            pre.left = sentinelTmp.left;
        } else {
            pre.right = sentinelTmp.left;
        }
        return sentinel.left;
    }
}
