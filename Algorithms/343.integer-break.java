/*
 * @lc app=leetcode.cn id=343 lang=java
 *
 * [343] 整数拆分
 */

// @lc code=start
class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];

        // 自底向上依次遍历
        for (int i = 1; i < n + 1; i++) {
            dp[i - 1] = Math.max(i - 1, dp[i - 1]);

            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[j] * dp[i - j]);
            }
        }

        return dp[n];
    }
}
// @lc code=end

