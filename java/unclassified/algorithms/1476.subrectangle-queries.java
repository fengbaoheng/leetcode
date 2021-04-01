/*
 * @lc app=leetcode.cn id=1476 lang=java
 *
 * [1476] 子矩形查询
 */

// @lc code=start
import java.util.*;

class SubrectangleQueries {

    private int[][] rectangle;
    private List<int[]> updates = new ArrayList<>();

    public SubrectangleQueries(int[][] rectangle) {
        this.rectangle = rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        updates.add(new int[]{row1, col1, row2, col2, newValue});
    }

    public int getValue(int row, int col) {
        for (int i = updates.size() - 1; i >= 0; i--) {
            int value = getValue(row, col, updates.get(i));
            if (value != -1) {
                return value;
            }
        }
        return rectangle[row][col];
    }

    private int getValue(int r, int c, int[] rect) {
        if (r >= rect[0] && r <= rect[2] && c >= rect[1] && c <= rect[3]) {
            return rect[4];
        } else {
            return -1;
        }
    }
}

/**
 * Your SubrectangleQueries object will be instantiated and called as such:
 * SubrectangleQueries obj = new SubrectangleQueries(rectangle);
 * obj.updateSubrectangle(row1,col1,row2,col2,newValue);
 * int param_2 = obj.getValue(row,col);
 */
// @lc code=end

