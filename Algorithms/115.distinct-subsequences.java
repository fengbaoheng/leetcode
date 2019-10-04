/*
 * @lc app=leetcode.cn id=115 lang=java
 *
 * [115] 不同的子序列
 */

// @lc code=start
class Solution {
    // 动态规划 使用dp[s][t]的二维数组空间
    // dp[i][j] = S[i~end]子序列中出现T[j~end]的个数
    // dp[i][j] =  dp[i+1][j] + ( S.charAt(i) == T.charAt(j) ? : dp[i+1][j+1] : 0 )
    // dp[0][0] 即为答案所求
    public int numDistinct(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();

        if(lenT == 0){
            return 1;
        }else if(lenS == 0){
            return 0;
        }

        int[][] dp = new int[lenS][lenT];

        // 最后一行 除了最后一列一定全为0
        dp[lenS - 1][lenT - 1] = s.charAt(lenS - 1) == t.charAt(lenT - 1) ? 1 : 0;

        // 最后一列 从最后一行依次向上查找
        int tEnd = lenT - 1;
        char tEndChar = t.charAt(tEnd);
        for (int i = lenS - 2; i >= 0; i--) {
            dp[i][tEnd] = dp[i + 1][tEnd];
            if (s.charAt(i) == tEndChar) {
                dp[i][tEnd]++;
            }
        }

        // 剩余列依次从下向上,从右向左
        for (int j = lenT - 2; j >= 0; j--) {
            for (int i = lenS - 2; i >= 0; i--) {
                dp[i][j] = dp[i + 1][j];
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] += dp[i + 1][j + 1];
                }
            }
        }

        return dp[0][0];
    }
}

// @lc code=end

