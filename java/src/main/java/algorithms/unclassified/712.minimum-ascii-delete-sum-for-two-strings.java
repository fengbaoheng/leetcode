/*
 * @lc app=leetcode.cn id=712 lang=java
 *
 * [712] 两个字符串的最小ASCII删除和
 */

// @lc code=start
class Solution {
    // 动态规划, 二维dp数组, dp[i][j]即minimumDeleteSum(s1[0-i], s2[0-j])
    // 第一行与第一列代表特殊情况 空字符串
    //     ' '  e  a  t
    // ' '  0   e  ea eat
    //  s   s
    //  e   se
    //  a   sea
    public int minimumDeleteSum(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();

        if (l1 == 0) {
            return getSum(s2);
        } else if (l2 == 0) {
            return getSum(s1);
        }

        // 第一行第一列为空字符串情况
        int row = l1 + 1;
        int col = l2 + 1;
        int[][] dp = new int[row][col];

        // 处理第一行 和 第一列
        for (int r = 1; r < row; r++) {
            dp[r][0] = dp[r - 1][0] + s1.charAt(r - 1);
        }
        for (int c = 1; c < col; c++) {
            dp[0][c] = dp[0][c - 1] + s2.charAt(c - 1);
        }

        // 依次处理剩余矩阵
        for (int r = 1; r < row; r++) {
            for (int c = 1; c < col; c++) {
                int charR = s1.charAt(r - 1);
                int charC = s2.charAt(c - 1);

                if (charR == charC) {
                    // 字符相同, 不需要删除
                    dp[r][c] = dp[r - 1][c - 1];
                } else {
                    // 字符不同, 则可以删除charR, 也可以删除charC
                    // 选择较小的删除值
                    int deleteCharR = charR + dp[r - 1][c];
                    int deleteCharC = charC + dp[r][c - 1];
                    dp[r][c] = Math.min(deleteCharR, deleteCharC);
                }
            }
        }

        return dp[row - 1][col - 1];
    }


    // 获取字符串所有值
    private int getSum(String s) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            sum += c;
        }
        return sum;
    }
}
// @lc code=end

