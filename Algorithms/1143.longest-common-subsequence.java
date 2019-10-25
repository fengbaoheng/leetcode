/*
 * @lc app=leetcode.cn id=1143 lang=java
 *
 * [1143] 最长公共子序列
 */

// @lc code=start
class Solution {
    // 动态规划 二维dp数组
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();

        if (len1 == 1 || len2 == 0) {
            return 0;
        }

        int rows = len1 + 1, cols = len2 + 1;

        // 最初补充空字符串
        int[][] dp = new int[rows][cols];

        // 第1行第1列均为0, 即空字符串和任何字符串都没有公共子序列

        for (int r = 1; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                int charR = text1.charAt(r - 1);
                int charC = text2.charAt(c - 1);

                if (charR == charC) {
                    // 字符相同, 则在之前的结果上+1
                    dp[r][c] = 1 + dp[r - 1][c - 1];
                } else {
                    // 字符不同,取前两个比较中的较大值 
                    dp[r][c] = Math.max(dp[r][c - 1], dp[r - 1][c]);
                }
            }
        }

        return dp[len1][len2];
    }
}
// @lc code=end

