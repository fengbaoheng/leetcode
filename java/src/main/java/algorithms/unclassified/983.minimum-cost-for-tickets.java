/*
 * @lc app=leetcode.cn id=983 lang=java
 *
 * [983] 最低票价
 */

// @lc code=start
import java.util.*;


class Solution {
    // 动态规划
    // dp[i] = min(dp[i-1]+cost1, dp[i-7]+cost7, dp[i-30]+cost30)
    public int mincostTickets(int[] days, int[] costs) {
        // 购票花费
        int cost1 = costs[0];
        int cost7 = costs[1];
        int cost30 = costs[2];

        Set<Integer> daySet = new HashSet<>();
        for (int day : days) {
            daySet.add(day);
        }

        // 最后一天
        int lastDay = days[days.length - 1];
        int[] dp = new int[lastDay + 1];

        for (int i = 1; i <= lastDay; i++) {
            // 没有旅行的日子不需要买票
            if (!daySet.contains(i)) {
                dp[i] = dp[i - 1];
                continue;
            }

            // 考虑三种购买方案的花费 取最小
            int s1 = cost1 + dp[i - 1];
            int s7 = cost7 + (i >= 7 ? dp[i - 7] : 0);
            int s30 = cost30 + (i >= 30 ? dp[i - 30] : 0);

            dp[i] = Math.min(s1, Math.min(s7, s30));
        }

        return dp[lastDay];
    }
}
// @lc code=end

