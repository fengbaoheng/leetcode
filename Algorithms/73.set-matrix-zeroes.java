/*
 * @lc app=leetcode.cn id=73 lang=java
 *
 * [73] 矩阵置零
 */

// @lc code=start
class Solution {
    private int rows, cols;
    private int[][] matrix;
    private boolean clearFirstRow, clearFirstCol;


    public void setZeroes(int[][] matrix) {
        this.matrix = matrix;
        rows = matrix.length;
        if (rows == 0) {
            return;
        }
        cols = matrix[0].length;


        // 使用首行和首列作为标记位
        markClearFirstRowAndCol();

        // 扫描所有格子，将清除标志记录在行的首部和列的首部
        for (int r = 1; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                if (matrix[r][c] == 0) {
                    matrix[r][0] = 0;
                    matrix[0][c] = 0;
                }
            }
        }

        // 读取标志位进行清除
        for (int r = 1; r < rows; r++) {
            if (matrix[r][0] == 0) {
                clearRow(r);
            }
        }

        for (int c = 1; c < cols; c++) {
            if (matrix[0][c] == 0) {
                clearCol(c);
            }
        }

        clearFirstRowAndColIfNeeded();
    }

    // 标记是否需要删除首行和首列
    private void markClearFirstRowAndCol() {
        clearFirstRow = false;
        clearFirstCol = false;

        if (matrix[0][0] == 0) {
            clearFirstRow = true;
            clearFirstCol = true;
            return;
        }

        for (int r = 1; r < rows; r++) {
            if (matrix[r][0] == 0) {
                clearFirstCol = true;
                break;
            }
        }

        for (int c = 1; c < cols; c++) {
            if (matrix[0][c] == 0) {
                clearFirstRow = true;
                break;
            }
        }
    }

    private void clearFirstRowAndColIfNeeded() {
        if (clearFirstRow) {
            clearRow(0);
        }

        if (clearFirstCol) {
            clearCol(0);
        }
    }

    private void clearRow(int row) {
        for (int c = 0; c < cols; c++) {
            matrix[row][c] = 0;
        }
    }

    private void clearCol(int col) {
        for (int r = 0; r < rows; r++) {
            matrix[r][col] = 0;
        }
    }
}
// @lc code=end

