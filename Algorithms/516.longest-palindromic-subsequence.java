/*
 * @lc app=leetcode.cn id=516 lang=java
 *
 * [516] 最长回文子序列
 */

// @lc code=start
class Solution {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        } else if (len == 1) {
            return 1;
        }

        int[][] dp = new int[len][len];

        // 初始化对角线
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }

        // 沿对角线遍历
        for (int d = 1; d < len; d++) {
            for (int r = 0; r < len - d; r++) {
                int c = r + d;
                if (s.charAt(r) == s.charAt(c)) {
                    dp[r][c] = 2 + dp[r + 1][c - 1];
                } else {
                    dp[r][c] = Math.max(dp[r][c - 1], dp[r + 1][c]);
                }
            }
        }

        return dp[0][len - 1];
    }
}
// @lc code=end
