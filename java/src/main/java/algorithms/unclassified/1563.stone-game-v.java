/*
 * @lc app=leetcode.cn id=1563 lang=java
 *
 * [1563] 石子游戏 V
 */

// @lc code=start
import java.util.Arrays;

class Solution {
    public int stoneGameV(int[] stoneValue) {
        final int n = stoneValue.length;

        // 计算前缀和，方便后续计算区间和
        int[] sums = Arrays.copyOf(stoneValue, stoneValue.length);
        for (int i = 1; i < n; i++) {
            sums[i] += sums[i - 1];
        }

        // 二维动态规划
        int[][] dp = new int[n][n];

        for (int k = 1; k < n; k++) {
            for (int r = 0; r < n; r++) {
                int end = r + k;
                if (end >= n) {
                    break;
                }

                int score = 0;

                // 依次尝试切割成两部分
                for (int c = r; c < end; c++) {
                    int left = getSum(sums, r, c);
                    int right = getSum(sums, c + 1, end);

                    if (left < right) {
                        // 拿取左边的小分数 + 继续对左边游戏
                        score = Math.max(score, left + dp[r][c]);
                    } else if (left > right) {
                        // 拿取右边的小分数 + 继续对右边游戏
                        score = Math.max(score, right + dp[c + 1][end]);
                    } else {
                        // 二者同时尝试
                        score = Math.max(score, left + dp[r][c]);
                        score = Math.max(score, right + dp[c + 1][end]);
                    }
                }

                dp[r][end] = score;
            }
        }


        return dp[0][n - 1];
    }

    private int getSum(int[] sums, int i, int j) {
        return i == 0 ? sums[j] : sums[j] - sums[i - 1];
    }
}
// @lc code=end

