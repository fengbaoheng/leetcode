/*
 * @lc app=leetcode.cn id=1260 lang=java
 *
 * [1260] 二维网格迁移
 */

// @lc code=start
import java.util.*;

class Solution {
    // 每次移动一列
    // 每m次移动一行
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        List<List<Integer>> kGrid = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>(m);
            for (int j = 0; j < m; j++) {
                row.add(0);
            }
            kGrid.add(row);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 最终列
                int c = j + k;

                // 每m列会下降1行
                int dr = Math.floorDiv(c, m);
                
                // 最终行
                int r = i + dr;
                
                // 循环
                r %= n;
                c %= m;
                kGrid.get(r).set(c, grid[i][j]);
            }
        }

        return kGrid;
    }
}
// @lc code=end

