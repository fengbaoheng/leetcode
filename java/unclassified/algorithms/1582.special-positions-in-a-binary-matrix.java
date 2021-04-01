/*
 * @lc app=leetcode.cn id=1582 lang=java
 *
 * [1582] 二进制矩阵中的特殊位置
 */

// @lc code=start
class Solution {
    public int numSpecial(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        int[] countRow = new int[rows];
        int[] countCol = new int[cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                countRow[r] += mat[r][c];
                countCol[c] += mat[r][c];
            }
        }

        int count = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (mat[r][c] == 1 && countRow[r] == 1 && countCol[c] == 1) {
                    count++;
                }
            }
        }

        return count;
    }
}
// @lc code=end

