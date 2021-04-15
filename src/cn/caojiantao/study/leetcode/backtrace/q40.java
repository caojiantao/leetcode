package cn.caojiantao.study.leetcode.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/combination-sum-ii/
 * 组合总和2
 */
public class q40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        dfs(new LinkedList<>(), candidates, target, res);
        return res;
    }

    public void dfs(LinkedList<Integer> path, int[] candidates, int target, List<List<Integer>> res) {
        if (target < 0) return;
        if (target == 0) {
            List<Integer> part = path.stream().map(item -> candidates[item]).collect(Collectors.toList());
            res.add(part);
            return;
        }
        int index = path.isEmpty() ? 0 : path.getLast() + 1;
        for (int i = index; i < candidates.length; i++) {
            path.addLast(i);
            target -= candidates[i];

            dfs(path, candidates, target, res);

            path.removeLast();
            target += candidates[i];

            while (i + 1 < candidates.length && candidates[i + 1] == candidates[i]) i++;
        }
    }
}
