/*
 * @lc app=leetcode.cn id=1314 lang=java
 *
 * [1314] 矩阵区域和
 */

// @lc code=start
import java.util.function.ToIntBiFunction;

class Solution {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int r = mat.length;
        int c = mat[0].length;

        // 计算二维矩阵前缀和
        int[][] P = new int[r + 1][c + 1];
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                int left = P[i][j - 1];
                int up = P[i - 1][j];
                int leftUp = P[i - 1][j - 1];
                P[i][j] = mat[i - 1][j - 1] + left + up - leftUp;
            }
        }

        ToIntBiFunction<Integer, Integer> func = (i, j) -> {
            if(i < 0 || j < 0){
                return 0;
            }
            int x = Math.min(i, r);
            int y =  Math.min(j, c);
            return P[x][y];
        };

        int[][] matrix = mat.clone();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int self = func.applyAsInt(i + K + 1, j + K + 1);
                int left = func.applyAsInt(i + K + 1, j - K);
                int up = func.applyAsInt(i - K, j + K + 1);
                int leftUp = func.applyAsInt(i - K, j - K);
                matrix[i][j] = self - left - up + leftUp;
            }
        }

        return matrix;
    }
}
// @lc code=end

