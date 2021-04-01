/*
 * @lc app=leetcode.cn id=647 lang=java
 *
 * [647] 回文子串
 */
class Solution {
    // 动态规划
    // db[i][j] 记录i~j是否回文
    // 转移方程: 
    // dp[i][j] = 1, i==j
    // dp[i][j] = (s[i] == s[j]) && (dp[i+1][j-1] == 1)
    public int countSubstrings(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }

        int[][] dp = new int[n][n];

        // 斜向遍历
        int count = 0;
        for (int layer = 0; layer < n; layer++) {
            for (int r = 0; r < n - layer; r++) {
                int c = r + layer;

                if (r == c) {
                    // 单字符一定回文
                    dp[r][c] = 1;
                } else if (s.charAt(r) == s.charAt(c)) {
                    // 两端字符相同
                    if (c == r + 1) {
                        // 当 c == r+1 即r,c相邻时一定回文
                        dp[r][c] = 1;
                    } else {
                        // 继续判断内部字符串是否回文
                        dp[r][c] = dp[r + 1][c - 1];
                    }
                }

                count += dp[r][c];
            }
        }

        return count;
    }
}