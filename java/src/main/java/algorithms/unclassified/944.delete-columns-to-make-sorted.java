/*
 * @lc app=leetcode.cn id=944 lang=java
 *
 * [944] 删列造序
 */

// @lc code=start
class Solution {
    public int minDeletionSize(String[] A) {
        int rows = A.length;
        int cols = A[0].length();

        int count = 0;
        for (int c = 0; c < cols; c++) {
            for (int r = 1; r < rows; r++) {
                if (A[r].charAt(c) < A[r - 1].charAt(c)) {
                    count++;
                    break;
                }
            }
        }

        return count;
    }
}
// @lc code=end

