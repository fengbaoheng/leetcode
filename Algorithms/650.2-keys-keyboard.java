/*
 * @lc app=leetcode.cn id=650 lang=java
 *
 * [650] 只有两个键的键盘
 */

// @lc code=start
class Solution {
    public int minSteps(int n) {
        int[] dp = new int[n + 1];

        // 通过1个A，复制一次后连续粘贴多次
        for (int i = 2; i <= n; i++) {
            dp[i] = i;
        }

        int half = Math.floorDiv(n, 2) + 1;
        for (int i = 2; i < half; i++) {
            // 在i的基础上复制1次粘贴多次
            int count = dp[i] + 2;

            // 粘贴1次
            for (int j = i + i; j <= n; j += i) {
                dp[j] = Math.min(dp[j], count);
                count++;
            }
        }

        return dp[n];
    }
}
// @lc code=end

