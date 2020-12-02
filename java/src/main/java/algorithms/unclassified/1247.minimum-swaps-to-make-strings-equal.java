/*
 * @lc app=leetcode.cn id=1247 lang=java
 *
 * [1247] 交换字符使得字符串相同
 */

// @lc code=start
class Solution {
    public int minimumSwap(String s1, String s2) {
        int len = s1.length();
        int countXY = 0;
        int countYX = 0;

        // 统计字符不同的对数
        // 即只统计x-y 与 y-x
        for (int i = 0; i < len; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 != c2) {
                if (c1 == 'x') {
                    countXY++;
                } else {
                    countYX++;
                }
            }
        }

        // x-y x-y 交换1次
        // y-x y-x 交换1次
        // x-y y-x 交换2次
        int remainXY = countXY % 2;
        int remainYX = countYX % 2;
        if (remainXY != remainYX) {
            return -1;
        }

        return countXY / 2 + countYX / 2 + remainXY + remainYX;
    }
}
// @lc code=end

