/*
 * @lc app=leetcode.cn id=1252 lang=java
 *
 * [1252] 奇数值单元格的数目
 */

// @lc code=start
class Solution {
    public int oddCells(int n, int m, int[][] indices) {
        int[] rows = new int[n];
        int[] cols = new int[m];

        for (int[] index : indices) {
            rows[index[0]]++;
            cols[index[1]]++;
        }

        int count = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                count += (rows[r] + cols[c]) % 2;
            }
        }

        return count;
    }
}
// @lc code=end

