/*
 * @lc app=leetcode.cn id=1043 lang=java
 *
 * [1043] 分隔数组以得到最大和
 */

// @lc code=start
class Solution {
    public int maxSumAfterPartitioning(int[] A, int K) {
        int n = A.length;
        int[] dp = new int[n];

        dp[0] = A[0];

        for (int i = 0; i < n; i++) {
            int left = Math.max(0, i - K + 1);
            int max = 0;
            for (int j = i; j >= left; j--) {
                max = Math.max(max, A[j]);
                int before = j > 0 ? dp[j - 1] : 0;
                int after = max * (i - j + 1);
                dp[i] = Math.max(dp[i], before + after);
            }
        }


        return dp[n - 1];
    }
}
// @lc code=end

