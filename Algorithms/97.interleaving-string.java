/*
 * @lc app=leetcode.cn id=97 lang=java
 *
 * [97] 交错字符串
 */

// @lc code=start
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();

        if (n3 != (n1 + n2)) {
            return false;
        }

        if (s1.isEmpty()) {
            return s3.equals(s2);
        }

        if (s2.isEmpty()) {
            return s3.equals(s1);
        }


        boolean[][] dp = new boolean[n1 + 1][n2 + 1];
        dp[0][0] = true;
        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                int k = i + j - 1;

                if (i > 0 && !dp[i][j]) {
                    dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(k);
                }

                if (j > 0 && !dp[i][j]) {
                    dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(k);
                }
            }
        }

        return dp[n1][n2];
    }
}
// @lc code=end

