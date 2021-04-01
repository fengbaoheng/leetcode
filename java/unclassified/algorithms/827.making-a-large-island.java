/*
 * @lc app=leetcode.cn id=827 lang=java
 *
 * [827] 最大人工岛
 */

// @lc code=start
import java.util.*;

class Solution {
    // 四个移动方向
    private static final int[][] MOVES = {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };

    private int[][] grid;
    private int rows, cols;

    // 记录岛屿
    private Island[][] islands;

    public int largestIsland(int[][] grid) {
        this.grid = grid;
        rows = grid.length;
        cols = grid[0].length;
        islands = new Island[rows][cols];

        // 搜索岛屿
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1 && islands[r][c] == null) {
                    new Island(r, c).search();
                }
            }
        }

        int maxArea = 1;
        int area = 1;
        // 寻找为0的空隙，将其相邻的岛屿连接起来
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    // 可能整个地图都是一个岛屿，没有空隙可以插入
                    area = islands[r][c].area;
                } else {
                    // 所有相邻岛屿面积总和
                    area = 1 + getNeighbors(r, c).stream().mapToInt(Island::getArea).sum();
                }

                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;

    }

    private boolean isValid(int r, int c) {
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }

    // 寻找周边的邻居岛屿，注意去除重复，可能多面相邻同一个岛屿
    private Set<Island> getNeighbors(int r, int c) {
        Set<Island> result = new HashSet<>(4);

        for (int[] move : MOVES) {
            int nr = r + move[0];
            int nc = c + move[1];

            if (isValid(nr, nc) && islands[nr][nc] != null) {
                result.add(islands[nr][nc]);
            }
        }

        return result;
    }

    // 岛屿类
    private class Island implements Comparable<Island> {
        private int area;
        private final Queue<int[]> toSearch = new LinkedList<>();

        public Island(int r, int c) {
            toSearch.add(new int[]{r, c});
            area = 1;
            islands[r][c] = this;
        }

        public int getArea() {
            return area;
        }

        // 广度优先搜索相邻的岛屿
        public void search() {
            while (!toSearch.isEmpty()) {
                int[] pos = toSearch.poll();

                for (int[] move : MOVES) {
                    int r = pos[0] + move[0];
                    int c = pos[1] + move[1];

                    if (!isValid(r, c) || grid[r][c] == 0 || islands[r][c] == this) {
                        continue;
                    }

                    area++;
                    islands[r][c] = this;
                    toSearch.offer(new int[]{r, c});
                }
            }
        }


        @Override
        public int compareTo(Island o) {
            return o.area - this.area;
        }
    }
}
// @lc code=end

