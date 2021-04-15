package cn.caojiantao.study.leetcode.array;

/**
 * https://leetcode-cn.com/problems/set-matrix-zeroes/
 * 矩阵置零
 */
public class q73 {

    public void setZeroes(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        boolean h = false, v = false;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                    if (i == 0) h = true;
                    if (j == 0) v = true;
                }
            }
        }
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                if ((matrix[0][j] == 0 && (j != 0 || v))
                        || (matrix[i][0] == 0 && (i != 0 || h))) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
