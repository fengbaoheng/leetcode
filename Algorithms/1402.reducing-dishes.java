/*
 * @lc app=leetcode.cn id=1402 lang=java
 *
 * [1402] 做菜顺序
 */

// @lc code=start
import java.util.Arrays;

class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        int size = satisfaction.length;
        if (size == 0) {
            return 0;
        }

        Arrays.sort(satisfaction);
        int[][] dp = new int[size][size];

        int max = 0;
        // 只做1道菜的情况
        for (int i = 0; i < size; i++) {
            dp[0][i] = satisfaction[i];
            max = Math.max(max, dp[0][i]);
        }

        // 只做i+1道菜的情况
        for (int i = 1; i < size; i++) {
            int time = i + 1;
            for (int j = i; j < size; j++) {
                dp[i][j] = dp[i - 1][j - 1] + time * satisfaction[j];
                max = Math.max(max, dp[i][j]);
            }
        }

        return max;
    }
}
// @lc code=end

