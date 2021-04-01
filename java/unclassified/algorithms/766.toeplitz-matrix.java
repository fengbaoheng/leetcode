/*
 * @lc app=leetcode.cn id=766 lang=java
 *
 * [766] 托普利茨矩阵
 */
class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        final int rows = matrix.length;
        final int cols = matrix[0].length;

        if (rows == 1 || cols == 1) {
            return true;
        }

        for (int r = 0; r < rows - 1; r++) {
            for (int c = 0; c < cols - 1; c++) {
                if(matrix[r][c] != matrix[r+1][c+1]){
                    return false;
                }
            }
        }

        return true;
    }
}
