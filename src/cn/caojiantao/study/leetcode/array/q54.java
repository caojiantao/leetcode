package cn.caojiantao.study.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/spiral-matrix/
 * 螺旋矩阵
 */
public class q54 {

    public static void main(String[] args) {
        q54 q54 = new q54();
        System.out.println(q54.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int rows = matrix.length, cols = matrix[0].length;
        int[][] next = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int left = 0, top = 0, right = cols - 1, bottom = rows - 1;
        int row = 0, col = 0;
        int direction = 0;
        for (int i = 0; i < rows * cols; i++) {
            res.add(matrix[row][col]);
            int next_row = row + next[direction][0];
            int next_col = col + next[direction][1];
            boolean flag = next_row == top && next_col == left;
            if (next_col > right || next_row > bottom || next_col < left || flag) {
                direction = (direction + 1) % next.length;
                if (flag) {
                    left++;
                    top++;
                    right--;
                    bottom--;
                }
            }
            row += next[direction][0];
            col += next[direction][1];
        }
        return res;
    }
}
