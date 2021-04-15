package cn.caojiantao.study.leetcode.dynamic;

/**
 * https://leetcode-cn.com/problems/unique-paths/
 * 不同路径
 */
public class q62 {

    /**
     * 空间复杂度 O(m*n)
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) dp[i][j] = 1;
                else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 空间复杂度 O(n)
     */
    public int uniquePathsV2(int m, int n) {
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) dp[j] = 1;
                else if (j != 0) {
                    dp[j] = dp[j] + dp[j - 1];
                }
            }
        }
        return dp[n - 1];
    }
}
