package cn.caojiantao.study.leetcode.dynamic;

/**
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * 最长上升子序列
 */
public class q300 {

    public static void main(String[] args) {
        q300 q300 = new q300();
        System.out.println(q300.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(q300.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
        System.out.println(q300.lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7}));
        System.out.println(q300.lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}));
    }

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int res = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            int n = nums[i];
            for (int j = i + 1; j <= nums.length; j++) {
                if (j == nums.length) dp[i]++;
                else if (n < nums[j]) dp[i] = Math.max(dp[i], dp[j]);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
