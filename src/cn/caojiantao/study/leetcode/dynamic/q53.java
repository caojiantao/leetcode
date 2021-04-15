package cn.caojiantao.study.leetcode.dynamic;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 * 最大子序和
 */
public class q53 {

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) dp[i] = nums[i];
            else dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
