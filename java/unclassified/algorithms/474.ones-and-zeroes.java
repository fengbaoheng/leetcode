/*
 * @lc app=leetcode.cn id=474 lang=java
 *
 * [474] 一和零
 */

// @lc code=start
class Solution {
    // 二维费用的01背包问题
    public int findMaxForm(String[] strs, int m, int n) {

        int[][] dp = new int[m + 1][n + 1];

        for (String str : strs) {
            int[] mn = getMN(str);
            int zero = mn[0];
            int one = mn[1];

            for (int i = m; i >= 0; i--) {
                for (int j = n; j >= 0; j--) {
                    int p = i - zero;
                    int q = j - one;
                    if (p >= 0 && q >= 0) {
                        dp[i][j] = Math.max(dp[i][j], 1 + dp[p][q]);
                    }
                }
            }
        }

        return dp[m][n];
    }


    private int[] getMN(String str) {
        int zero = 0, one = 0;
        for (char c : str.toCharArray()) {
            if (c == '0') {
                zero++;
            } else {
                one++;
            }
        }
        return new int[]{zero, one};
    }
}
// @lc code=end

