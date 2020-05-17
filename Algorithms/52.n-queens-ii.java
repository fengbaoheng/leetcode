/*
 * @lc app=leetcode.cn id=52 lang=java
 *
 * [52] N皇后 II
 */

// @lc code=start
class Solution {
    private int solutions;
    private Board board;
    private int n;

    public int totalNQueens(int n) {
        this.n = n;
        solutions = 0;
        board = new Board();

        search(0);

        return solutions;
    }

    private void search(int row) {
        if (row >= n) {
            solutions++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (board.setQueen(row, col)) {
                search(row + 1);
                board.removeQueen(row, col);
            }
        }
    }


    private class Board {
        private final boolean[][] arr;

        private final boolean[] rowOccupy;
        private final boolean[] colOccupy;
        private final boolean[] leftOccupy;
        private final boolean[] rightOccupy;

        public Board() {
            arr = new boolean[n][n];
            rowOccupy = new boolean[n];
            colOccupy = new boolean[n];
            leftOccupy = new boolean[n + n];
            rightOccupy = new boolean[n + n];
        }

        /**
         * 在指定位置放置皇后
         *
         * @param row 行
         * @param col 列
         * @return 是否放置成功
         */
        public boolean setQueen(int row, int col) {
            if (canSet(row, col)) {
                occupy(row, col, true);
                return true;
            } else {
                return false;
            }
        }

        private boolean canSet(int row, int col) {
            int left = row - col + n - 1;
            int right = row + col;
            return !(arr[row][col] || rowOccupy[row] || colOccupy[col] || leftOccupy[left] || rightOccupy[right]);
        }

        /**
         * 移除皇后
         *
         * @param row 行
         * @param col 列
         */
        public void removeQueen(int row, int col) {
            occupy(row, col, false);
        }

        private void occupy(int row, int col, boolean isOccupy) {
            arr[row][col] = isOccupy;

            int left = row - col + n - 1;
            int right = row + col;
            rowOccupy[row] = isOccupy;
            colOccupy[col] = isOccupy;
            leftOccupy[left] = isOccupy;
            rightOccupy[right] = isOccupy;
        }
    }
}
// @lc code=end

