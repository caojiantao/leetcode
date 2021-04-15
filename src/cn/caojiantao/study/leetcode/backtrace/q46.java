package cn.caojiantao.study.leetcode.backtrace;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/permutations/
 * 全排列
 */
public class q46 {

    private LinkedList<Integer> path = new LinkedList<>();
    private Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        q46 q46 = new q46();
        System.out.println(q46.permute(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, res);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int n : nums) {
            if (set.contains(n)) continue;
            path.addLast(n);
            set.add(n);

            dfs(nums, res);

            path.removeLast();
            set.remove(n);
        }
    }
}
