/*
 * @lc app=leetcode.cn id=1301 lang=java
 *
 * [1301] 最大得分的路径数目
 */

// @lc code=start
import java.util.*;

class Solution {
    private static final int MOD = 1000000007;

    public int[] pathsWithMaxScore(List<String> board) {
        int size = board.size();

        int[][][] dp = new int[size][size][2];
        dp[size - 1][size - 1][1] = 1;

        // 从右下角向左向上扫描
        for (int c = size - 1; c >= 0; c--) {
            for (int r = size - 1; r >= 0; r--) {
                char ch = board.get(r).charAt(c);

                // 遇障碍跳过
                if (ch == 'X' || ch == 'S') {
                    continue;
                }

                // 周围三种邻居: 右, 下, 右下
                List<int[]> neighbors = new LinkedList<>();
                if (r < size - 1) {
                    neighbors.add(dp[r + 1][c]);
                }
                if (c < size - 1) {
                    neighbors.add(dp[r][c + 1]);
                }
                if (r < size - 1 && c < size - 1) {
                    neighbors.add(dp[r + 1][c + 1]);
                }

                // 筛选最大分值
                int maxScore = 0;
                for (int[] neighbor : neighbors) {
                    maxScore = Math.max(maxScore, neighbor[0]);
                }

                // 累积方案数目
                int sumCount = 0;
                for (int[] neighbor : neighbors) {
                    if (neighbor[0] == maxScore) {
                        sumCount += neighbor[1];
                        sumCount %= MOD;
                    }
                }

                // 死路 
                if (sumCount == 0) {
                    continue;
                }

                // 结束标志
                if (ch == 'E') {
                    return new int[]{maxScore, sumCount};
                }

                // 累积分数
                dp[r][c][0] = maxScore + (ch - '0');
                dp[r][c][1] = sumCount;
            }
        }


        return new int[]{0, 0};
    }
}
// @lc code=end

