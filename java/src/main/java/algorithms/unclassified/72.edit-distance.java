/*
 * @lc app=leetcode.cn id=72 lang=java
 *
 * [72] 编辑距离
 */

// @lc code=start
class Solution {
    // 动态规划 二维
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        // 0行0列使用空字符补充
        int[][] dp = new int[len1 + 1][len2 + 1];

        // 初始化0行0列
        // word1变为空字符串 只能删除
        for (int r = 0; r <= len1; r++) {
            dp[r][0] = r;
        }

        // 空字符串变为word2 只能添加
        for (int c = 0; c <= len2; c++) {
            dp[0][c] = c;
        }

        for (int r = 1; r <= len1; r++) {
            for (int c = 1; c <= len2; c++) {
                char ch1 = word1.charAt(r - 1);
                char ch2 = word2.charAt(c - 1);

                // 替换
                // 两字符相同则替换字符不耗费操作
                int replace = dp[r - 1][c - 1] + (ch1 == ch2 ? 0 : 1);

                // 添加
                int add = dp[r][c - 1] + 1;

                // 删除
                int delete = 1 + dp[r - 1][c];


                dp[r][c] = Math.min(add, Math.min(delete, replace));
            }
        }


        return dp[len1][len2];
    }
}
// @lc code=end

