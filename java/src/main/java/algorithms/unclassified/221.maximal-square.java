/*
 * @lc app=leetcode.cn id=221 lang=java
 *
 * [221] 最大正方形
 */

// @lc code=start
class Solution {
    // 将每个1，看作是正方形的左上角
    // 依次向下搜索
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) {
            return 0;
        }
        int cols = matrix[0].length;

        // 记录每个1处的宽度，减少搜索的次数
        int[][] width = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            int w = 0;
            for (int c = cols - 1; c >= 0; c--) {
                int num = matrix[r][c] - '0';
                if (num == 0) {
                    w = 0;
                } else {
                    width[r][c] = ++w;
                }
            }
        }

        // 正方形最大的边长
        int d = 0;

        // 依次遍历每个1
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int w = width[r][c];
                if (w == 0) {
                    continue;
                }

                // 边长的上限值即向右扩展的极限和向下扩展的极限
                int maxH = Math.min(w, rows - r);
                int minW = w;
                for (int h = 1; h <= maxH; h++) {
                    // 根据每一行的宽度快速判断
                    minW = Math.min(minW, width[r + h - 1][c]);
                    if(minW < h){
                        break;
                    }

                    d = Math.max(d, h);
                }
            }
        }

        return d * d;
    }
}
// @lc code=end

