/*
 * @lc app=leetcode.cn id=1020 lang=java
 *
 * [1020] 飞地的数量
 */

// @lc code=start
class Solution {
    int[][] A;
    int rows;
    int cols;
    int[][] moves = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int numEnclaves(int[][] A) {
        this.A = A;
        this.rows = A.length;
        this.cols = A[0].length;

        for (int r = 0; r < rows; r++) {
            dfs(r, 0);
            dfs(r, cols - 1);
        }

        for (int c = 0; c < cols; c++) {
            dfs(0, c);
            dfs(rows - 1, c);
        }

        int count = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (A[r][c] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int r, int c) {
        if (A[r][c] != 1) {
            return;
        }

        A[r][c] = 2;
        for (int[] move : moves) {
            int nr = r + move[0];
            int nc = c + move[1];
            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
                dfs(nr, nc);
            }
        }
    }
}
// @lc code=end

