/*
 * @lc app=leetcode.cn id=121 lang=csharp
 *
 * [121] 买卖股票的最佳时机
 *
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/description/
 *
 * algorithms
 * Easy (48.28%)
 * Total Accepted:    32K
 * Total Submissions: 65.9K
 * Testcase Example:  '[7,1,5,3,6,4]'
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * 
 * 注意你不能在买入股票前卖出股票。
 * 
 * 示例 1:
 * 
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * ⁠    注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 
 * 
 * 示例 2:
 * 
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * 
 * 
 */
public class Solution
{
    public int MaxProfit(int[] prices)
    {
        // 少于两天的数据 无法完成交易
        if (prices.Length < 2) { return 0; }

        // 暴力枚举 O(n2)

        var Max = prices[0];
        var Min = prices[0];
        var profit = 0;

        foreach (var price in prices)
        {
            if (price < Min)
            {
                Min = price;
                Max = price;
            }
            else if (price > Max)
            {
                Max = price;
            }

            var priceDiff = Max - Min;
            if (priceDiff > profit)
            {
                profit = priceDiff;
            }
        }

        return profit;
    }
}

