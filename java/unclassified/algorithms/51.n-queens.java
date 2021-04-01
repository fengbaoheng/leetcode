/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N皇后
 */

// @lc code=start
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    private List<List<String>> solutions;
    private Board board;
    private int n;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        solutions = new LinkedList<>();
        board = new Board();

        search(0);

        return solutions;
    }

    private void search(int row) {
        if (row >= n) {
            solutions.add(board.format());
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

        private final Set<Integer> rowOccupy = new HashSet<>();
        private final Set<Integer> colOccupy = new HashSet<>();
        private final Set<Integer> leftOccupy = new HashSet<>();
        private final Set<Integer> rightOccupy = new HashSet<>();

        public Board() {
            this.arr = new boolean[n][n];
        }

        public List<String> format() {
            return IntStream.range(0, n).mapToObj(this::format).collect(Collectors.toList());
        }

        private String format(int row) {
            char[] chars = new char[n];
            for (int col = 0; col < n; col++) {
                chars[col] = arr[row][col] ? 'Q' : '.';
            }
            return new String(chars);
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
            int left = row - col;
            int right = row + col;
            return !(arr[row][col] || rowOccupy.contains(row) || colOccupy.contains(col)
                    || leftOccupy.contains(left) || rightOccupy.contains(right));
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

            int left = row - col;
            int right = row + col;
            if (isOccupy) {
                rowOccupy.add(row);
                colOccupy.add(col);
                leftOccupy.add(left);
                rightOccupy.add(right);
            } else {
                rowOccupy.remove(row);
                colOccupy.remove(col);
                leftOccupy.remove(left);
                rightOccupy.remove(right);
            }
        }
    }
}
// @lc code=end

