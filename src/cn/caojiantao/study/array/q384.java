package cn.caojiantao.study.array;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * https://leetcode-cn.com/problems/shuffle-an-array/
 * 打乱数组
 */
public class q384 {

    public static void main(String[] args) {
        q384 q384 = new q384(new int[]{1,2,3});
        System.out.println(Arrays.toString(q384.shuffle()));
        System.out.println(Arrays.toString(q384.reset()));
        System.out.println(Arrays.toString(q384.shuffle()));
    }

    private int[] nums;

    public q384(int[] nums) {
        this.nums = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return this.nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] arr = Arrays.copyOf(this.nums, this.nums.length);
        ThreadLocalRandom random = ThreadLocalRandom.current();
        for (int i = 0; i < arr.length; i++) {
            int index = random.nextInt(arr.length - i);
            int n = arr[index];
            arr[index] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = n;
        }
        return arr;
    }
}
