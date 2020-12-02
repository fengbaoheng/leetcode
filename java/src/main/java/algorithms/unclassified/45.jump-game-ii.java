/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
import java.util.*;


class Solution {
    public int jump(int[] nums) {
        int len = nums.length;

        int[] dp = new int[len];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for (int i = 0; i < nums.length; i++) {
            int steps = nums[i];
            int min = dp[i] + 1;
            for (int j = 1; j <= steps; j++) {
                int k = i + j;
                if (k >= len) {
                    break;
                }
                dp[k] = Math.min(dp[k], min);
            }

        }

        return dp[len - 1];
    }
}
// @lc code=end

