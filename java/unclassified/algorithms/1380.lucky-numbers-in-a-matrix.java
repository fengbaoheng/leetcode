import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1380 lang=java
 *
 * [1380] 矩阵中的幸运数
 */

// @lc code=start
class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] minCol = new int[m];
        int[] maxRow = new int[n];

        // 遍历元素 寻找行最小的列, 列最大的行
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int num = matrix[r][c];
                if (num < matrix[r][minCol[r]]) {
                    minCol[r] = c;
                }

                if (num > matrix[maxRow[c]][c]) {
                    maxRow[c] = r;
                }
            }
        }

        // 比对结果并输出
        List<Integer> results = new LinkedList<>();
        for (int r = 0; r < m; r++) {
            if (r == maxRow[minCol[r]]) {
                results.add(matrix[r][minCol[r]]);
            }
        }
        return results;
    }
}
// @lc code=end
