/*
 * @lc app=leetcode.cn id=1359 lang=java
 *
 * [1359] 有效的快递序列数目
 */

// @lc code=start
class Solution {
    private static int M = 1000000007;

    public int countOrders(int n) {
        long[][] dp = new long[n + 1][n + 1];
        
        // 初始化情况，一直收却不发
        // 沿着斜线遍历 从左下至右上
        dp[n][0] = 1;
        for (int r = n - 1; r >= 0; r--) {
            int c = n - r;
            dp[r][c] = (r + 1) * dp[r + 1][c - 1];
            dp[r][c] %= M;
        }
        
        // 斜线遍历
        for (int s = n - 1; s >= 0; s--) {
            dp[s][0] += dp[s][1];
            for (int r = s - 1; r >= 0; r--) {
                int c = s - r;
                dp[r][c] = (r + 1) * dp[r + 1][c - 1] + (c + 1) * dp[r][c + 1];
                dp[r][c] %= M;
            }
        }
        
        return (int) (dp[0][0] % M);
    }
}
// @lc code=end

