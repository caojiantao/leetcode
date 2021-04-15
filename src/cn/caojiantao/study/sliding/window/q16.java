package cn.caojiantao.study.sliding.window;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/3sum-closest/
 * 最接近的三数之和
 */
public class q16 {

    public static void main(String[] args) {
        q16 q16 = new q16();
        System.out.println(q16.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
        System.out.println(q16.threeSumClosest(new int[]{0, 2, 1, -3}, 1));
    }

    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int res = 0, div = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int flag = target - nums[i];
            for (int l = i + 1, r = nums.length - 1; l < r; ) {
                int sum = nums[l] + nums[r];
                if (sum < flag) {
                    l++;
                } else if (sum == flag) {
                    return target;
                } else {
                    r--;
                }
                int divTemp = Math.abs(flag - sum);
                if (divTemp < div) {
                    res = sum + nums[i];
                    div = divTemp;
                }
            }
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) i++;
        }
        return res;
    }
}
