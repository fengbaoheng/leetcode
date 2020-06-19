/*
 * @lc app=leetcode.cn id=583 lang=java
 *
 * [583] 两个字符串的删除操作
 */

// @lc code=start
class Solution {
    public int minDistance(String word1, String word2) {
        int rows = word1.length() + 1;
        int cols = word2.length() + 1;

        int[][] dp = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i < cols; i++) {
            dp[0][i] = i;
        }

        for (int r = 1; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                char ch1 = word1.charAt(r - 1);
                char ch2 = word2.charAt(c - 1);

                if (ch1 == ch2) {
                    dp[r][c] = dp[r - 1][c - 1];
                } else {
                    dp[r][c] = 1 + Math.min(dp[r - 1][c], dp[r][c - 1]);
                }
            }
        }

        return dp[rows - 1][cols - 1];
    }
}
// @lc code=end

