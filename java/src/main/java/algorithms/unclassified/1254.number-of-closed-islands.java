/*
 * @lc app=leetcode.cn id=1254 lang=java
 *
 * [1254] 统计封闭岛屿的数目
 */

// @lc code=start
import java.util.*;


class Solution {
    private int[][] grid;
    private int rows;
    private int cols;

    // 每次的移动范围
    private int[][] moves = new int[][]{
            {0, -1}, {0, 1}, {-1, 0}, {1, 0}
    };

    // 记录每个岛屿是否封闭
    private Map<Integer, Boolean> map = new HashMap<>();

    public int closedIsland(int[][] grid) {
        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;

        // 岛屿编号
        int index = 2;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // 发现新陆地
                if (grid[r][c] == 0) {
                    // 默认该陆地封闭
                    map.put(index, true);
                    dfs(r, c, index);
                    index++;
                }
            }
        }

        int count = 0;
        for (Boolean island : map.values()) {
            count += island ? 1 : 0;
        }

        return count;
    }

    /**
     * 深度优先搜索陆地
     *
     * @param r     行
     * @param c     列
     * @param index 陆地编号
     */
    void dfs(int r, int c, int index) {
        // 陆地不封闭
        if (r < 0 || r >= rows || c < 0 || c >= cols) {
            map.put(index, false);
            return;
        }

        // 无法继续搜索
        if (grid[r][c] != 0) {
            return;
        }

        grid[r][c] = index;

        for (int[] move : moves) {
            int nextR = r + move[0];
            int nextC = c + move[1];

            dfs(nextR, nextC, index);
        }
    }
}
// @lc code=end

