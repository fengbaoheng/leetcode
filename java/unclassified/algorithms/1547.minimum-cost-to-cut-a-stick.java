/*
 * @lc app=leetcode.cn id=1547 lang=java
 *
 * [1547] 切棍子的最小成本
 */

// @lc code=start
import java.util.Arrays;

class Solution {
    public int minCost(int n, int[] cuts) {
        cuts = getCuts(n, cuts);
        int m = cuts.length;

        int[][] dp = new int[m][m];

        // 斜线遍历
        for (int k = 0; k < cuts.length; k++) {
            for (int r = m - k - 3; r >= 0; r--) {
                int c = r + k + 2;
                dp[r][c] = Integer.MAX_VALUE;

                // 在[r,c]之间选择一个切点切下后的最小成本
                for (int i = r + 1; i < c; i++) {
                    dp[r][c] = Math.min(dp[r][c], dp[r][i] + dp[i][c]);
                }

                // 切割[r,c]的固定成本
                dp[r][c] += cuts[c] - cuts[r];
            }
        }

        return dp[0][m - 1];
    }

    // 添加两端的虚拟切点，并排序
    private int[] getCuts(int n, int[] cuts) {
        int len = cuts.length;
        int[] newCuts = new int[len + 2];
        System.arraycopy(cuts, 0, newCuts, 0, len);
        newCuts[len] = n;
        Arrays.sort(newCuts);
        return newCuts;
    }
}
// @lc code=end

