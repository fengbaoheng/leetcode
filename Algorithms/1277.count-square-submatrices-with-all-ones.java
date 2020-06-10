/*
 * @lc app=leetcode.cn id=1277 lang=java
 *
 * [1277] 统计全为 1 的正方形子矩阵
 */

// @lc code=start
class Solution {
    private int[][] matrix;
    private int rows, cols;

    public int countSquares(int[][] matrix) {
        this.matrix = matrix;
        rows = matrix.length;
        cols = matrix[0].length;

        int count = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                count += countSquare(r, c);
            }
        }

        return count;
    }

    private int countSquare(int r, int c) {
        if (matrix[r][c] == 0) {
            return 0;
        }

        int radius = 1;
        while (checkSquare(r, c, radius)) {
            radius++;
        }

        return radius;
    }

    private boolean checkSquare(int r, int c, int radius) {
        int x = r + radius;
        int y = c + radius;

        if (!isValid(x, y) || matrix[x][y] == 0) {
            return false;
        }

        x = r + radius;
        for (int dc = 0; dc <= radius; dc++) {
            y = c + dc;
            if (matrix[x][y] == 0) {
                return false;
            }
        }

        y = c + radius;
        for (int dr = 0; dr < radius; dr++) {
            x = r + dr;
            if (matrix[x][y] == 0) {
                return false;
            }
        }

        return true;
    }

    private boolean isValid(int r, int c) {
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }
}
// @lc code=end

