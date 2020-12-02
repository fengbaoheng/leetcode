/*
 * @lc app=leetcode.cn id=1030 lang=java
 *
 * [1030] 距离顺序排列矩阵单元格
 */

// @lc code=start
import java.util.*;

class Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        // 录入所有坐标
        List<int[]> cells = new ArrayList<>(R * C);
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                cells.add(new int[]{r, c});
            }
        }

        // 按距离排序
        cells.sort(Comparator.comparingInt(cell -> Math.abs(cell[0] - r0) + Math.abs(cell[1] - c0)));

        return cells.toArray(new int[][]{});
    }
}
// @lc code=end

