package cn.caojiantao.study.array;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/
 * 最短无序连续子数组
 */
public class q581 {

    public static void main(String[] args) {
        q581 q581 = new q581();
        System.out.println(q581.findUnsortedSubarrayV2(new int[]{2, 6, 4, 8, 10, 9, 15}));
        System.out.println(q581.findUnsortedSubarrayV2(new int[]{1, 2, 3, 4,}));
        System.out.println(q581.findUnsortedSubarrayV2(new int[]{0}));
    }

    /**
     * 拷贝数组，排序后与原数组比较
     */
    public int findUnsortedSubarray(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        int i = 0, j = nums.length - 1;
        while (i < j && nums[i] == copy[i]) i++;
        while (i < j && nums[j] == copy[j]) j--;
        return i == j ? 0 : j - i + 1;
    }

    public int findUnsortedSubarrayV2(int[] nums) {
        int left = 0, right = -1;
        int min = nums[nums.length - 1], max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < max) {
                right = i;
            } else {
                max = nums[i];
            }
            int j = nums.length - 1 - i;
            if (nums[j] > min) {
                left = j;
            } else {
                min = nums[j];
            }
        }
        return right - left + 1;
    }
}
