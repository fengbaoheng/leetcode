/*
 * @lc app=leetcode.cn id=309 lang=java
 *
 * [309] 最佳买卖股票时机含冷冻期
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        final int N = prices.length;
        if (N < 2) {
            return 0;
        }

        int[] dp = new int[N];
        for (int i = N - 2; i >= 0; i--) {
            // 第i天不交易的利润
            dp[i] = dp[i + 1];

            // 计算第i天买入的利润
            int buyPrice = prices[i];
            // 分别尝试在第j天卖出
            for (int j = i + 1; j < N; j++) {
                int sellPrice = prices[j];
                int profit = sellPrice - buyPrice;

                // 赚不到利润则跳过
                if (profit <= 0) {
                    continue;
                }

                // j天卖出后，后续交易能获取的最大利润
                int followProfit = hasNextDeal(j, N) ? dp[nextBuyDay(j)] : 0;

                dp[i] = Math.max(dp[i], profit + followProfit);

            }
        }

        return dp[0];
    }

    private boolean hasNextDeal(int sellDay, int totalDay) {
        return sellDay <= totalDay - 4;
    }

    private int nextBuyDay(int sellDay) {
        return sellDay + 2;
    }
}
// @lc code=end

