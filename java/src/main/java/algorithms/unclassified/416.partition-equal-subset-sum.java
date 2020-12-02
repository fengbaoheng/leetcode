/*
 * @lc app=leetcode.cn id=416 lang=java
 *
 * [416] 分割等和子集
 */

// @lc code=start
import java.util.stream.IntStream;

class Solution {
    public boolean canPartition(int[] nums) {
        final int totalSum = IntStream.of(nums).sum();

        if (totalSum % 2 != 0) {
            return false;
        }

        // 01背包问题
        // 假设背包容量为总和的一半
        // 判断从nums中选取部分物品恰好填满背包
        final int halfSum = totalSum / 2;

        boolean[] dp = new boolean[halfSum + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int i = dp.length - 1; i >= 0; i--) {
                if (dp[i] || (i - num >= 0 && dp[i - num])) {
                    dp[i] = true;
                }
            }
        }

        return dp[halfSum];
    }
}
// @lc code=end

