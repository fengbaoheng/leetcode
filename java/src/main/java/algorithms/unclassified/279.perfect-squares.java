/*
 * @lc app=leetcode.cn id=279 lang=java
 *
 * [279] 完全平方数
 */

// @lc code=start
import java.util.*;


class Solution {
    public int numSquares(int n) {
        // n是否为完全平方数
        int s = (int) Math.sqrt(n);
        if (s * s == n) {
            return 1;
        }

        // 查找完全平方数
        List<Integer> squares = new ArrayList<>();
        for (int i = 0; i * i < n + 1; i++) {
            squares.add(i * i);
        }

        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (squares.contains(i)) {
                // 是完全平方数
                dp[i] = 1;
            } else if (dp[i - 1] == 1) {
                // 当前不是完全平方数, 则最小值也只是2
                // 那么当左侧是完全平方数, 当前就为2
                dp[i] = 2;
            } else {
                // 循环判断取最小和
                dp[i] = i;
                for (Integer square : squares) {
                    if (square > i) {
                        break;
                    }
                    int sum = dp[square] + dp[i - square];
                    if (sum < dp[i]) {
                        dp[i] = sum;
                    }
                }
            }
        }

        return dp[n];
    }
}
// @lc code=end

