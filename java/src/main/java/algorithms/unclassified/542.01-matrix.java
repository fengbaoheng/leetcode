/*
 * @lc app=leetcode.cn id=542 lang=java
 *
 * [542] 01 矩阵
 */

// @lc code=start
import java.util.*;


class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new ArrayDeque<>(rows * cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int val = matrix[i][j];
                if (val == 0) {
                    visited[i][j] = true;
                    queue.add(new int[]{i, j});
                }
            }
        }


        int len = 0;
        int[][] moves = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            len += 1;

            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] move : moves) {
                    int r = cur[0] + move[0];
                    int c = cur[1] + move[1];

                    if (r >= 0 && r < rows && c >= 0 && c < cols && !visited[r][c]) {
                        matrix[r][c] = len;
                        visited[r][c] = true;
                        queue.add(new int[]{r, c});
                    }
                }
            }
        }

        return matrix;
    }
}
// @lc code=end

