/*
 * @lc app=leetcode.cn id=980 lang=java
 *
 * [980] 不同路径 III
 */

// @lc code=start
import java.util.*;

class Solution {
    private int[][] grid;
    private int rows;
    private int cols;
    private int[][] moves = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int zeros;
    private int count;

    public int uniquePathsIII(int[][] grid) {
        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;
        zeros = 0;

        int startR = 0, startC = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                final int val = grid[r][c];
                if (val == 1) {
                    startR = r;
                    startC = c;
                } else if (val == 0) {
                    zeros++;
                }
            }
        }

        count = 0;
        for (int[] next : getNext(startR, startC)) {
            dfs(next[0], next[1]);
        }

        return count;
    }

    private void dfs(int r, int c) {
        int val = grid[r][c];
        if (val == 2 && zeros == 0) {
            count++;
            return;
        }

        if (val != 0) {
            return;
        }

        grid[r][c] = 3;
        zeros--;

        for (int[] next : getNext(r, c)) {
            dfs(next[0], next[1]);
        }

        grid[r][c] = 0;
        zeros++;
    }

    private List<int[]> getNext(int r, int c) {
        List<int[]> list = new ArrayList<>(4);
        for (int i = 0; i < 4; i++) {
            int nr = r + moves[i][0];
            int nc = c + moves[i][1];
            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
                list.add(new int[]{nr, nc});
            }
        }
        return list;
    }
}
// @lc code=end

