/*
 * @lc app=leetcode.cn id=1504 lang=java
 *
 * [1504] 统计全 1 子矩形
 */

// @lc code=start
class Solution {
    public int numSubmat(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        // 统计每个1的宽度
        int[][] widths = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            int width = 0;
            for (int c = cols - 1; c >= 0; c--) {
                if (mat[r][c] == 0) {
                    width = 0;
                } else {
                    width++;
                }
                widths[r][c] = width;
            }
        }


        int count = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (mat[r][c] == 0) {
                    continue;
                }

                // 向下搜索
                int width = Integer.MAX_VALUE;
                for (int ri = r; ri < rows; ri++) {
                    width = Math.min(width, widths[ri][c]);
                    if (width == 0) {
                        break;
                    }
                    count += width;
                }
            }
        }

        return count;
    }
}
// @lc code=end

