package cn.caojiantao.study.leetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * 数组中的第K个最大元素
 */
public class q215 {

    public static void main(String[] args) {
        q215 q215 = new q215();
        System.out.println(q215.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(q215.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, Comparator.comparingInt(k2 -> k2));
        for (int n : nums) {
            if (heap.size() < k) {
                heap.add(n);
            } else if (heap.peek() < n) {
                heap.poll();
                heap.add(n);
            }
        }
        return heap.poll();
    }
}
