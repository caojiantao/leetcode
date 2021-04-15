package cn.caojiantao.study.dynamic;

/**
 * https://leetcode-cn.com/problems/minimum-path-sum/
 * 最小路径和
 */
public class q64 {

    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int num = grid[i][j];
                if (i == 0) dp[j] = (j == 0) ? num : dp[j - 1] + num;
                else if (j == 0) dp[j] += num;
                else dp[j] = Math.min(dp[j - 1], dp[j]) + num;
            }
        }
        return dp[n - 1];
    }
}
