/*
 * @lc app=leetcode.cn id=883 lang=java
 *
 * [883] 三维形体投影面积
 */
class Solution {
    // 分别找行列最大值累加即可
    public int projectionArea(int[][] grid) {
        final int N = grid.length;

        int sum1 = 0;
        int[] maxI = new int[N];
        int[] maxJ = new int[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int num = grid[i][j];
                if (num == 0) {
                    continue;
                }

                // 俯视图累积
                sum1 += 1;

                // 记录行列最大值
                if (num > maxI[i]) {
                    maxI[i] = num;
                }

                if (num > maxJ[j]) {
                    maxJ[j] = num;
                }
            }
        }

        int sum2 = 0;
        for (int num : maxI) {
            sum2 += num;
        }

        int sum3 = 0;
        for (int num : maxJ) {
            sum3 += num;
        }

        return sum1 + sum2 + sum3;
    }
}
