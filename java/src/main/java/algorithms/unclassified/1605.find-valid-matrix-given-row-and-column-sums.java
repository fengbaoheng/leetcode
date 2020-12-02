/*
 * @lc app=leetcode.cn id=1605 lang=java
 *
 * [1605] 给定行和列的和求可行矩阵
 */

// @lc code=start
class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int rows = rowSum.length;
        int cols = colSum.length;
        int[][] m = new int[rows][cols];

        // 第一行满足列和，但是行和肯定溢出
        m[0] = colSum.clone();

        // 对剩余行，只需要依次从第一行转移数字，满足该行的行和即可
        int C = 0;
        for (int r = 1; r < rows; r++) {
            int remain = rowSum[r];
            while (remain > 0) {
                if (m[0][C] <= remain) {
                    // 全部转移
                    remain -= m[0][C];
                    m[r][C] = m[0][C];
                    m[0][C] = 0;
                    C++;
                } else {
                    // 部分转移
                    m[0][C] -= remain;
                    m[r][C] = remain;
                    remain = 0;
                }
            }
        }

        return m;
    }
}
// @lc code=end

