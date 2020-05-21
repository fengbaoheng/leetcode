/*
 * @lc app=leetcode.cn id=813 lang=java
 *
 * [813] 最大平均值和的分组
 */

// @lc code=start
import java.util.Arrays;

class Solution {
    public double largestSumOfAverages(int[] A, int K) {
        Mean mean = new Mean(A);

        double[][] dp = new double[K + 1][A.length];

        // 初始化 K==1的情况
        for (int i = 0; i < A.length; i++) {
            dp[1][i] = mean.of(i);
        }

        for (int k = 2; k <= K; k++) {
            for (int q = k - 1; q < A.length; q++) {
                for (int p = k - 1; p <= q; p++) {
                    dp[k][q] = Math.max(dp[k][q], dp[k - 1][p - 1] + mean.of(p, q));
                }
            }
        }


        return dp[K][A.length - 1];
    }


    private class Mean {
        private final int[] accumulation;

        public Mean(int[] A) {
            accumulation = Arrays.copyOf(A, A.length);
            for (int i = 1; i < A.length; i++) {
                accumulation[i] += accumulation[i - 1];
            }
        }

        public double of(int start, int end) {
            if (start == 0) {
                return of(end);
            }
            return (accumulation[end] - accumulation[start - 1]) / (end - start + 1.0);
        }

        public double of(int end) {
            return accumulation[end] / (end + 1.0);
        }
    }
}
// @lc code=end

