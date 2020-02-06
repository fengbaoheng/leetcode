/*
 * @lc app=leetcode.cn id=1329 lang=java
 *
 * [1329] 将矩阵按对角线排序
 */

// @lc code=start
import java.util.*;

class Solution {
    int[][] mat;
    int[][] sorted;
    int m, n;

    public int[][] diagonalSort(int[][] mat) {
        m = mat.length;
        n = mat[0].length;

        this.mat = mat;
        sorted = new int[m][n];

        // 第0行 所有列依次
        for (int c = 0; c < n; c++) {
            sort(0, c);
        }

        // 所有行 第0列
        for (int r = 0; r < m; r++) {
            sort(r, 0);
        }

        return sorted;
    }

    /**
     * 对矩阵的某个斜线排序
     *
     * @param x 左上角x坐标
     * @param y 左上角y坐标
     */
    private void sort(int x, int y) {
        List<Integer> nums = new ArrayList<>();

        // 取出斜线上的数字
        int r = x, c = y;
        while (r < m && c < n) {
            nums.add(mat[r][c]);
            r++;
            c++;
        }

        // 排序
        nums.sort(Integer::compareTo);

        // 将排序后的数字重写回矩阵
        r = x;
        c = y;
        for (Integer num : nums) {
            sorted[r][c] = num;
            r++;
            c++;
        }
    }
}
// @lc code=end

