/*
 * @lc app=leetcode.cn id=486 lang=java
 *
 * [486] 预测赢家
 */

// @lc code=start
class Solution {
    // 动态规划
    public boolean PredictTheWinner(int[] nums) {
        int len = nums.length;

        if (len <= 2) {
            return true;
        }

        // dp[i][j][0] 记录 nums[i]~nums[j] 先手拿取的最高分数
        // dp[i][j][1] 记录 nums[i]~nums[j] 后手拿取的最高分数
        int[][][] dp = new int[len][len][2];

        // 沿对角线初始化, 当只有一个数时, 先手拿全部的分数, 后手零分
        for (int i = 0; i < len; i++) {
            dp[i][i][0] = nums[i];
        }

        // 依次按对角线求解
        for (int dj = 1; dj < len; dj++) {
            for (int i = 0; i < len - dj; i++) {
                int j = i + dj;

                int headFirst = nums[i] + dp[i + 1][j][1];
                int headSecond = dp[i + 1][j][0];

                int tailFirst = nums[j] + dp[i][j - 1][1];
                int tailSecond = dp[i][j - 1][0];

                if (headFirst >= tailFirst) {
                    dp[i][j][0] = headFirst;
                    dp[i][j][1] = headSecond;
                } else {
                    dp[i][j][0] = tailFirst;
                    dp[i][j][1] = tailSecond;
                }
            }
        }

        return dp[0][len - 1][0] >= dp[0][len - 1][1];
    }
}
// @lc code=end

