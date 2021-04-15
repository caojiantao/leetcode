package cn.caojiantao.study.heap;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 * 前K个高频元素
 */
public class q347 {

    public static void main(String[] args) {
        q347 q347 = new q347();
        System.out.println(Arrays.toString(q347.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
        System.out.println(Arrays.toString(q347.topKFrequent(new int[]{1}, 1)));
        System.out.println(Arrays.toString(q347.topKFrequent(new int[]{3, 0, 1, 0}, 1)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) map.put(n, map.getOrDefault(n, 0) + 1);
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, Comparator.comparingInt(map::get));
        for (Integer n : map.keySet()) {
            if (heap.size() < k) {
                heap.add(n);
            } else if (map.get(heap.peek()) < map.get(n)) {
                heap.poll();
                heap.add(n);
            }
        }
        return Arrays.stream(heap.toArray(new Integer[0])).mapToInt(item -> item).toArray();
    }
}
