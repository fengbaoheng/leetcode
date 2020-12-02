/*
 * @lc app=leetcode.cn id=1351 lang=java
 *
 * [1351] 统计有序矩阵中的负数
 */

// @lc code=start
class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int count = 0;
        int startRow = 0;
        // 最后1列向左遍历
        for (int col = n - 1; col >= 0; col--) {
            // 第1行向下
            for (int row = startRow; row < m; row++) {
                int num = grid[row][col];
                if (num >= 0) {
                    // 遇到正数, 则左侧全为正数
                    startRow = row + 1;
                } else {
                    // 遇到负数, 则下侧全为负数
                    // 不必再向下遍历
                    count += m - row;
                    break;
                }
            }
        }

        return count;
    }
}
// @lc code=end

