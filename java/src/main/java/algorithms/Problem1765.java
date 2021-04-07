package algorithms;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 1765.地图中的最高点
 */
public class Problem1765 {
    static class Solution {
        private int[][] MOVES = {
                {1, 0}, {-1, 0}, {0, 1}, {0, -1},
        };

        public int[][] highestPeak(int[][] isWater) {
            int rows = isWater.length;
            int cols = isWater[0].length;

            int[][] result = new int[rows][cols];
            boolean[][] confirmed = new boolean[rows][cols];


            // 遍历水域，高度一定为0
            Queue<int[]> queue = new ArrayDeque<>();
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    if (isWater[r][c] == 1) {
                        confirmed[r][c] = true;
                        result[r][c] = 0;
                        queue.add(new int[]{r, c});
                    }
                }
            }

            // 初始高度
            int height = 0;

            // 广度优先搜索
            while (!queue.isEmpty()) {
                // 相邻高度递增
                height++;

                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    final int[] position = queue.poll();
                    // 添加周围节点
                    for (int[] move : MOVES) {
                        int x = position[0] + move[0];
                        int y = position[1] + move[1];
                        if (x >= 0 && x < rows && y >= 0 && y < cols && !confirmed[x][y]) {
                            confirmed[x][y] = true;
                            result[x][y] = height;
                            queue.offer(new int[]{x, y});
                        }
                    }
                }
            }

            return result;
        }
    }
}