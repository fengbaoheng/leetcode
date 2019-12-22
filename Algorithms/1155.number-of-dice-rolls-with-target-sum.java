/*
 * @lc app=leetcode.cn id=1155 lang=java
 *
 * [1155] 掷骰子的N种方法
 */

// @lc code=start
class Solution {
    private static final int MOD = 1000000007;

    // 二维动态规划
    public int numRollsToTarget(int d, int f, int target) {
        if (target < d || target > d * f) {
            return 0;
        }

        // 行数=骰子数
        // 列数=target
        int[][] dp = new int[d + 1][target + 1];

        f = Math.min(f, target);

        // 只有一个骰子的最简情况
        for (int df = 1; df <= f; df++) {
            dp[1][df] = 1;
        }

        // 依次向下递推
        for (int r = 1; r <= d; r++) {
            for (int c = 0; c <= target; c++) {
                for (int df = 1; df <= f; df++) {
                    int lastC = c - df;
                    if (lastC >= 0) {
                        dp[r][c] += dp[r - 1][lastC];
                        dp[r][c] %= MOD;
                    }
                }
            }
        }


        return dp[d][target];
    }
}
// @lc code=end

