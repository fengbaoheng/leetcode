/*
 * @lc app=leetcode.cn id=1269 lang=java
 *
 * [1269] 停在原地的方案数
 */

// @lc code=start
class Solution {
    // 二维动态规划
    public int numWays(int steps, int arrLen) {
        int[] dp = new int[arrLen];
        int[] next = new int[arrLen];

        dp[0] = 1;
        for (int step = 1; step <= steps; step++) {
            for (int i = 0; i < arrLen; i++) {
                long result = 0L;
                result += i > 0 ? dp[i - 1] : 0;
                result += dp[i];
                result += i < arrLen - 1 ? dp[i + 1] : 0;
                next[i] = (int) (result % 1000000007);
            }
            int[] tmp = dp;
            dp = next;
            next = tmp;
        }

        return dp[0];
    }
}
// @lc code=end

