package cn.caojiantao.study.leetcode.tree;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * 二叉树的层次遍历
 */
public class q102 {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        dfs(Collections.singletonList(root));
        return res;
    }

    private void dfs(List<TreeNode> rowList) {
        List<Integer> part = new ArrayList<>();
        List<TreeNode> nextRowList = new ArrayList<>();
        for (TreeNode node : rowList) {
            if (node == null) continue;
            part.add(node.val);
            nextRowList.add(node.left);
            nextRowList.add(node.right);
        }
        if (part.isEmpty()) return;
        res.add(part);
        dfs(nextRowList);
    }

    private List<List<Integer>> bfs(TreeNode root) {
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> part = new ArrayList<>();
            while (n-- > 0) {
                TreeNode node = queue.poll();
                part.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(part);
        }
        return res;
    }
}
