/*
 * @lc app=leetcode.cn id=329 lang=java
 *
 * [329] 矩阵中的最长递增路径
 */

// @lc code=start
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        return new Matrix(matrix).search();
    }
}

class Matrix {
    private final int rows, cols;
    private final int[][] matrix;
    private final int[][] path;

    public Matrix(int[][] matrix) {
        this.matrix = matrix;
        this.rows = matrix.length;

        if (rows > 0) {
            this.cols = matrix[0].length;
        } else {
            this.cols = 0;
        }

        path = new int[rows][cols];
    }

    public int search() {
        if (rows == 0 || cols == 0) {
            return 0;
        }

        int longest = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                longest = Math.max(longest, search(r, c));
            }
        }

        return longest;
    }

    public int search(int r, int c) {
        if (!isValid(r, c)) {
            return 0;
        }

        // 如果搜索过则longestPath至少为1
        int longestPath = path[r][c];
        if (longestPath != 0) {
            return longestPath;
        }

        int value = matrix[r][c];

        // 上下左右深度搜索
        int up = canMove(r - 1, c, value) ? search(r - 1, c) : 0;
        int down = canMove(r + 1, c, value) ? search(r + 1, c) : 0;
        int left = canMove(r, c - 1, value) ? search(r, c - 1) : 0;
        int right = canMove(r, c + 1, value) ? search(r, c + 1) : 0;


        // 取各个方向的最大值加上本身的长度1
        longestPath = 1 + Math.max(Math.max(up, down), Math.max(left, right));
        path[r][c] = longestPath;
        
        return longestPath;
    }

    private boolean canMove(int r, int c, int value) {
        return r >= 0 && r < rows && c >= 0 && c < cols && value < matrix[r][c];
    }

    private boolean isValid(int r, int c) {
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }
}
// @lc code=end

