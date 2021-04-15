package cn.caojiantao.study.leetcode.dynamic;

/**
 * https://leetcode-cn.com/problems/longest-common-subsequence/
 * 最长公共子序列
 */
public class q1143 {

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean match = text1.charAt(i) == text2.charAt(j);
                if (match) {
                    dp[i][j] = (i == 0 || j == 0) ? 1 : dp[i - 1][j - 1] + 1;
                } else {
                    int top = (i == 0) ? 0 : dp[i - 1][j];
                    int left = (j == 0) ? 0 : dp[i][j - 1];
                    dp[i][j] = Math.max(top, left);
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }

    /**
     * 行列+1，简化边界处理
     */
    public int longestCommonSubsequenceV2(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        int res = 0;
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}
