/*
 * @lc app=leetcode.cn id=518 lang=java
 *
 * [518] 零钱兑换 II
 */

// @lc code=start
class Solution {
    // 动态规划 完全背包问题
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];

        // 凑成0元的方案
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }
}
// @lc code=end
