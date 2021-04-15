package cn.caojiantao.study.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/partition-labels/
 * 划分字母区间
 */
public class q763 {

    public static void main(String[] args) {
        q763 q763 = new q763();
        System.out.println(q763.partitionLabelsV2("ababcbacadefegdehijhklij"));
    }

    public List<Integer> partitionLabels(String S) {
        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        for (int p = 0; p < S.length(); p++) {
            j = Math.max(j, S.lastIndexOf(S.charAt(p)));
            if (p == j) {
                list.add(j - i + 1);
                i = j + 1;
            }
        }
        return list;
    }

    public List<Integer> partitionLabelsV2(String S) {
        List<Integer> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            map.put(S.charAt(i), i);
        }
        int i = 0, j = 0;
        for (int p = 0; p < S.length(); p++) {
            j = Math.max(j, map.get(S.charAt(p)) + 1);
            if (p + 1 == j) {
                list.add(j - i);
                i = j;
            }
        }
        return list;
    }
}
