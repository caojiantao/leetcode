package cn.caojiantao.study.division;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 在排序数组中查找元素的第一个和最后一个位置
 */
public class q34 {

    public static void main(String[] args) {
        q34 q34 = new q34();
        System.out.println(Arrays.toString(q34.searchRange(new int[]{1, 2, 2, 3, 3, 4, 5}, 0)));
    }

    public int[] searchRange(int[] nums, int target) {
        return new int[]{searchLeft(nums, target), searchRight(nums, target)};
    }

    private int searchLeft(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target <= nums[mid]) end = mid - 1;
            else start = mid + 1;
        }
        if (start < 0 || start == nums.length || nums[start] != target) start = -1;
        return start;
    }

    private int searchRight(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target >= nums[mid]) start = mid + 1;
            else end = mid - 1;
        }
        if (end < 0 || end == nums.length || nums[end] != target) end = -1;
        return end;
    }
}
