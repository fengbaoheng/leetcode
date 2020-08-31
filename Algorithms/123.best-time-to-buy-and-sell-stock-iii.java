/*
 * @lc app=leetcode.cn id=123 lang=java
 *
 * [123] 买卖股票的最佳时机 III
 */

// @lc code=start
class Solution {


    public int maxProfit(int[] prices) {
        int days = prices.length;

        if (days <= 1) {
            return 0;
        }

        int[][][] dp = new int[days][2][2];

        // 初始化第一天状态
        dp[0][0][0] = 0;
        dp[0][0][1] = -prices[0];
        dp[0][1][0] = Integer.MIN_VALUE;
        dp[0][1][1] = Integer.MIN_VALUE;


        // 每一天
        for (int day = 1; day < days; day++) {
            int price = prices[day];

            // 第一次交易

            // 持有股票: 1.不操作; 2.买入股票
            dp[day][0][1] = Math.max(dp[day - 1][0][1], -price);

            // 不持有股票: 1.不操作; 2.卖出持有的股票
            dp[day][0][0] = Math.max(dp[day - 1][0][0], dp[day - 1][0][1] + price);

            // 第二次交易

            // 持有股票: 1.不操作; 2.在第一交易完成的基础上买入股票
            dp[day][1][1] = Math.max(dp[day - 1][1][1], dp[day - 1][0][0] - price);

            // 不持有股票: 1.不操作; 2.卖出买入的股票
            dp[day][1][0] = Math.max(dp[day - 1][1][0], dp[day - 1][1][1] + price);
        }

        return Math.max(dp[days - 1][0][0], dp[days - 1][1][0]);
    }
}
// @lc code=end

