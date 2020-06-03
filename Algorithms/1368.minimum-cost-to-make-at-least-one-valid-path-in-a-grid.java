/*
 * @lc app=leetcode.cn id=1368 lang=java
 *
 * [1368] 使网格图至少有一条有效路径的最小代价
 */

// @lc code=start
import java.util.*;

class Solution {
    static final int RIGHT = 1;
    static final int LEFT = 2;
    static final int DOWN = 3;
    static final int UP = 4;

    static final int[][] MOVES = {{0, 1, LEFT}, {0, -1, RIGHT}, {1, 0, UP}, {-1, 0, DOWN}};

    public int minCost(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] cost = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            Arrays.fill(cost[r], Integer.MAX_VALUE);
        }

        cost[rows - 1][cols - 1] = 0;
        Queue<int[]> queue = new ArrayDeque<>(rows * cols);
        queue.add(new int[]{rows - 1, cols - 1});

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] loc = queue.poll();
                int curCost = cost[loc[0]][loc[1]];
                for (int[] move : MOVES) {
                    int r = loc[0] + move[0];
                    int c = loc[1] + move[1];
                    if (r >= 0 && r < rows && c >= 0 && c < cols) {
                        int minCost = curCost;
                        if (grid[r][c] != move[2]) {
                            minCost += 1;
                        }

                        if (minCost < cost[r][c]) {
                            cost[r][c] = minCost;
                            queue.add(new int[]{r, c});
                        }
                    }
                }
            }
        }

        return cost[0][0];
    }
}
// @lc code=end

