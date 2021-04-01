/*
 * @lc app=leetcode.cn id=1220 lang=java
 *
 * [1220] 统计元音字母序列的数目
 */

// @lc code=start
class Solution {
    private static final int MOD = 1000000007;

    // 二维动态规划
    public int countVowelPermutation(int n) {
        // 行为n的数量
        // 5列代表5个字母
        long[][] dp = new long[n][5];

        // 只有一位时, 每个字母开头只有一种情况
        for (int i = 0; i < 5; i++) {
            dp[0][i] = 1L;
        }

        // 依次向下遍历
        for (int row = 1; row < n; row++) {
            long a = dp[row - 1][0];
            long e = dp[row - 1][1];
            long i = dp[row - 1][2];
            long o = dp[row - 1][3];
            long u = dp[row - 1][4];

            // 递推衔接情况
            dp[row][0] = (e + i + u) % MOD;
            dp[row][1] = (a + i) % MOD;
            dp[row][2] = (e + o) % MOD;
            dp[row][3] = (i) % MOD;
            dp[row][4] = (i + o) % MOD;
        }

        int result = 0;

        for (int i = 0; i < 5; i++) {
            result += dp[n - 1][i];
            result %= MOD;
        }

        return result;
    }
}
// @lc code=end

