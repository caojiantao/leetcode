package cn.caojiantao.study.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/subsets/
 * 子集
 */
public class q78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(new ArrayList<>(), nums, res, 0);
        return res;
    }

    private void backtrack(List<Integer> path, int[] nums, List<List<Integer>> res, int index) {
        res.add(new ArrayList<>(path));
        for (; index < nums.length; index++) {
            path.add(nums[index]);
            backtrack(path, nums, res, index + 1);
            path.remove(path.size() - 1);
        }
    }
}
