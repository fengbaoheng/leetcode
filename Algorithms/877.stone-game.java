/*
 * @lc app=leetcode.cn id=877 lang=java
 *
 * [877] 石子游戏
 */

class Solution {
    // 动态规划
    // 设dp[i][j] 代表在i-j堆石子情况下, 拿到的石子数量
    // dp[i][j][0] 代表先手拿到的数量, dp[i][j][1] 代表后手拿到的数量
    // dp[i][j][0] = max(piles[i] + dp[i+1][j][1], piles[j] + dp[i][j-1][1])
    // dp[i][j][1] = total - dp[i][j][0]
    // i == j: 只有一堆, 先手拿走全部, 后手拿走0
    // j - i == 1: 只有两堆, 先手拿走最大的一堆, 后手拿走最小的一堆
    public boolean stoneGame(int[] piles) {
        int length = piles.length;

        int[][][] dp = new int[length][length][2];

        for (int i = 0; i < length; i++) {
            dp[i][i][0] = piles[i];
            dp[i][i][1] = 0;
        }

        for (int layer = 1; layer < length; layer++) {
            for (int i = 0; i < length - layer; i++) {
                int j = i + layer;

                int left = piles[i] + dp[i + 1][j][1];
                int right = piles[j] + dp[i][j - 1][1];

                if (left > right) {
                    dp[i][j][0] = left;
                    dp[i][j][1] = dp[i + 1][j][0];
                } else {
                    dp[i][j][0] = right;
                    dp[i][j][1] = dp[i][j - 1][0];
                }
            }
        }

        return dp[0][length - 1][0] > dp[0][length - 1][1];
    }
}