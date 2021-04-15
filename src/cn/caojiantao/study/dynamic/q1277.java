package cn.caojiantao.study.dynamic;

/**
 * https://leetcode-cn.com/problems/count-square-submatrices-with-all-ones/
 * 统计全为1的正方形子矩阵
 */
public class q1277 {

    public static void main(String[] args) {
        q1277 q1277 = new q1277();
        System.out.println(q1277.countSquares(new int[][]{{0, 1, 1, 1}, {1, 1, 0, 1}, {1, 1, 1, 1}, {1, 0, 1, 0}}));
    }

    /**
     * dp[i][j] 指 i,j 区域内的正方形个数。
     *
     * 当 dp[i][j] == 1 时，需要遍历正方形边，转移方程较为复杂
     */
    public int countSquares(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1];

                for (int len = 0; i - 1 - len >= 0 && j - 1 - len >= 0; len++) {
                    boolean flag = true;
                    int row = i - 1 - len, col = j - 1 - len;
                    for (int p = row, q = col; p <= i - 1 && q <= j - 1; p++, q++) {
                        if (matrix[row][q] != 1 || matrix[p][col] != 1) {
                            flag = false;
                            break;
                        }
                    }
                    if (!flag) break;
                    dp[i][j]++;
                }
            }
        }
        return dp[m][n];
    }

    /**
     * dp[i][j] 指以 i,j 为右下角的正方形个数，及边长
     *
     * 当 dp[i][j] == 1 时，只需取”左、左上、上“三个位置的最小边长，即为当前最大正方形边长，及个数
     * <code>
     *     dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
     * </code>
     */
    public int countSquaresV2(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int res = 0;
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (matrix[i - 1][j - 1] == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
                res += dp[i][j];
            }
        }
        return res;
    }
}
