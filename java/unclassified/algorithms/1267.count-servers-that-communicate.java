/*
 * @lc app=leetcode.cn id=1267 lang=java
 *
 * [1267] 统计参与通信的服务器
 */

// @lc code=start
class Solution {
    public int countServers(int[][] grid) {
        final int rows = grid.length;
        final int cols = grid[0].length;

        // 记录行列上的服务器数量
        int[] rowCount = new int[rows];
        int[] colCount = new int[cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] != 1) {
                    continue;
                }
                rowCount[r]++;
                colCount[c]++;
            }
        }

        // 若行列上有其它服务器存在, 即rowCount, colCount > 1时
        // 本服务器可以通信
        int count = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    if (rowCount[r] > 1 || colCount[c] > 1) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
// @lc code=end

