/*
 * @lc app=leetcode.cn id=1289 lang=java
 *
 * [1289] 下降路径最小和  II
 */

// @lc code=start
class Solution {
    public int minFallingPathSum(int[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;

        for (int r = 1; r < rows; r++) {
            // 寻找上一行中最小值和次小值
            int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
            int minC = 0;
            for (int c = 0; c < cols; c++) {
                int val = arr[r - 1][c];
                if (val < min1) {
                    min2 = min1;
                    min1 = val;
                    minC = c;
                } else if (val < min2) {
                    min2 = val;
                }
            }

            // 累加最小值, 但最小值列除外
            for (int c = 0; c < cols; c++) {
                if (c == minC) {
                    arr[r][c] += min2;
                } else {
                    arr[r][c] += min1;
                }
            }
        }
        
        int result = Integer.MAX_VALUE;
        for (int c = 0; c < cols; c++) {
            int val = arr[rows - 1][c];
            if (val < result) {
                result = val;
            }
        }

        return result;
    }
}
// @lc code=end

