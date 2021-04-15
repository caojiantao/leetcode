package cn.caojiantao.study.merge.segment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/merge-intervals/submissions/
 * 合并区间
 */
public class q56 {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(item -> item[0]));
        List<int[]> list = new ArrayList<>();
        int[] pre = null;
        for (int[] segment : intervals) {
            int i = segment[0], j = segment[1];
            if (pre == null || i > pre[1]) {
                pre = new int[]{i, j};
                list.add(pre);
            } else if (j > pre[1]) {
                pre[1] = j;
            }
        }
        return list.toArray(new int[list.size()][2]);
    }
}
