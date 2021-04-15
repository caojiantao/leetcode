package cn.caojiantao.study.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 * 二叉树的后序遍历
 */
public class q145 {

    private List<Integer> res = new ArrayList<>();

    public static void main(String[] args) {
        q145 q145 = new q145();
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode a = new TreeNode(1, b, c);
        System.out.println(q145.postorderTraversalV2(a));
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return res;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        res.add(root.val);
        return res;
    }

    /**
     * pre 指针，标识上次遍历过的子树节点
     */
    public List<Integer> postorderTraversalV2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            TreeNode right = pop.right;
            if (right == null || right == pre) {
                res.add(pop.val);
                pre = pop;
            } else {
                stack.push(pop);
                root = right;
            }
        }
        return res;
    }
}
