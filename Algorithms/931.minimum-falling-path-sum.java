/*
 * @lc app=leetcode.cn id=931 lang=java
 *
 * [931] 下降路径最小和
 */
class Solution {
    // 从最后一行逆推向上
    public int minFallingPathSum(int[][] A) {
        int rows = A.length;
        int cols = A[0].length;

        int[][] sum = new int[rows][cols];

        final int MAX = 101;

        // 最后一行不变
        for (int c = 0; c < cols; c++) {
            sum[rows - 1][c] = A[rows - 1][c];
        }

        // 从下往上累积
        for (int r = rows - 2; r >= 0; r--) {
            // 比较下一行相邻列中较小的值累加
            for (int c = 0; c < cols; c++) {
                int left = c != 0 ? sum[r + 1][c - 1] : MAX;
                int mid = sum[r + 1][c];
                int right = c != cols - 1 ? sum[r + 1][c + 1] : MAX;

                sum[r][c] = A[r][c] + Math.min(mid, Math.min(left, right));
            }
        }

        int result = MAX;
        for (int num : sum[0]) {
            if (num < result) {
                result = num;
            }
        }
        return result;
    }
}

