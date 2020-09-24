/*
 * @lc app=leetcode.cn id=174 lang=java
 *
 * [174] 地下城游戏
 */

// @lc code=start
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int rows = dungeon.length;
        int cols = dungeon[0].length;

        int[][] dp = new int[rows][cols];


        // 处理最后一行
        int minHP = dungeon[rows - 1][cols - 1];
        dp[rows - 1][cols - 1] = minHP >= 0 ? 1 : 1 - minHP;
        for (int c = cols - 2; c >= 0; c--) {
            minHP = dp[rows - 1][c + 1] - dungeon[rows - 1][c];
            dp[rows - 1][c] = minHP <= 0 ? 1 : minHP;
        }

        // 从下向上 从右向左 的遍历
        // 寻找右侧和下侧哪个需要的HP低就选择哪个
        for (int r = rows - 2; r >= 0; r--) {
            for (int c = cols - 1; c >= 0; c--) {
                int right = c == cols - 1 ? Integer.MAX_VALUE : dp[r][c + 1];
                int down = dp[r + 1][c];

                minHP = Math.min(right, down) - dungeon[r][c];
                dp[r][c] = minHP <= 0 ? 1 : minHP;
            }
        }


        return dp[0][0];
    }
}
// @lc code=end

