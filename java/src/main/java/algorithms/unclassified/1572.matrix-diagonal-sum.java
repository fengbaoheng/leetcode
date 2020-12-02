/*
 * @lc app=leetcode.cn id=1572 lang=java
 *
 * [1572] 矩阵对角线元素的和
 */

// @lc code=start
class Solution {
    public int diagonalSum(int[][] mat) {
        int result = 0;

        int n = mat.length;

        for (int r = 0; r < n; r++) {
            result += mat[r][r];
            result += mat[r][n - r - 1];
        }

        if (n % 2 == 1) {
            result -= mat[n / 2][n / 2];
        }

        return result;
    }
}
// @lc code=end

