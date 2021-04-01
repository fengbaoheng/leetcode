/*
 * @lc app=leetcode.cn id=1162 lang=java
 *
 * [1162] 地图分析
 */

// @lc code=start
import java.util.*;

class Solution {
    public int maxDistance(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new ArrayDeque<>(rows * cols);
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    queue.add(new int[]{r, c});
                }
            }
        }

        int maxDistance = -1;

        // 全为岛屿
        if (queue.size() == rows * cols) {
            return maxDistance;
        }

        int[][] moves = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        final int VISITED = 2;
        while (!queue.isEmpty()) {
            maxDistance++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] island = queue.poll();
                for (int[] move : moves) {
                    int nr = island[0] + move[0];
                    int nc = island[1] + move[1];
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
                        int val = grid[nr][nc];
                        if (val == 0) {
                            queue.add(new int[]{nr, nc});
                            grid[nr][nc] = VISITED;
                        }
                    }
                }
            }
        }

        return maxDistance;
    }
}
// @lc code=end

