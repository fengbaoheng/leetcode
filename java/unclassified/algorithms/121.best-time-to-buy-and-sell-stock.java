/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */
// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int N = prices.length;
        if (N < 2) {
            return 0;
        }

        int maxSellPrice = prices[N - 1];
        int maxProfit = 0;

        for (int i = N - 2; i >= 0; i--) {
            int buyPrice = prices[i];
            int profit = maxSellPrice - buyPrice;

            maxProfit = Math.max(maxProfit, profit);
            maxSellPrice = Math.max(maxSellPrice, buyPrice);
        }

        return maxProfit;
    }
}
// @lc code=end