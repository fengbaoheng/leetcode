/*
 * @lc app=leetcode.cn id=130 lang=java
 *
 * [130] 被围绕的区域
 */
class Solution {
    private char[][] board;
    private int rowCount;
    private int colCount;

    // 深度优先
    public void solve(char[][] board) {
        rowCount = board.length;
        if (rowCount == 0) {
            return;
        }

        colCount = board[0].length;
        if (colCount == 0) {
            return;
        }

        this.board = board;

        // 遍历边界上的'O'
        for (int r = 0; r < rowCount; r++) {
            for (int c = 0; c < colCount; c++) {
                boolean isBorder = r == 0 || r == rowCount - 1 || c == 0 || c == colCount - 1;
                if (isBorder && board[r][c] == 'O') {
                    dfs(r, c);
                }
            }
        }

        replace();
    }

    private void dfs(int r, int c) {
        if (r < 0 || r >= rowCount || c < 0 || c >= colCount || board[r][c] != 'O') {
            return;
        }

        // 搜索标记
        board[r][c] = '-';

        int[] neighbors = new int[] { r - 1, c, r + 1, c, r, c + 1, r, c - 1 };
        for (int i = 0; i < neighbors.length; i += 2) {
            dfs(neighbors[i], neighbors[i + 1]);
        }
    }

    // 替换标记
    private void replace() {
        for (int r = 0; r < rowCount; r++) {
            for (int c = 0; c < colCount; c++) {
                if (board[r][c] == '-') {
                    board[r][c] = 'O';
                } else if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                }
            }
        }
    }
}
