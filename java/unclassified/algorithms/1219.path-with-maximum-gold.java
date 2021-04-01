/*
 * @lc app=leetcode.cn id=1219 lang=java
 *
 * [1219] 黄金矿工
 */

// @lc code=start
import java.util.*;

class Solution {
    private Cell[][] cells;
    private int rows;
    private int cols;
    private int max;

    private static final int[] dr = {0, 0, -1, 1};
    private static final int[] dc = {-1, 1, 0, 0};

    public int getMaximumGold(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        cells = new Cell[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                cells[r][c] = new Cell(r, c, grid[r][c]);
            }
        }

        max = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                Cell cell = cells[r][c];
                max = Math.max(max, cell.enter());
            }
        }

        return max;
    }

    private class Cell {
        final int row;
        final int col;
        final int value;
        boolean canEnter;

        public Cell(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
            this.canEnter = value != 0;
        }

        private int enter() {
            if (!canEnter) {
                return 0;
            }
            canEnter = false;

            int gold = value + getNeighbors().stream().mapToInt(Cell::enter).max().orElse(0);

            if (value != 0) {
                canEnter = true;
            }

            return gold;
        }

        private List<Cell> getNeighbors() {
            List<Cell> neighbors = new ArrayList<>(4);
            for (int i = 0; i < 4; i++) {
                int r = row + dr[i];
                int c = col + dc[i];
                if (r >= 0 && r < rows && c >= 0 && c < cols) {
                    neighbors.add(cells[r][c]);
                }
            }
            return neighbors;
        }
    }
}
// @lc code=end

