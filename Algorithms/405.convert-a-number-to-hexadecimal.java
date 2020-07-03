/*
 * @lc app=leetcode.cn id=405 lang=java
 *
 * [405] 数字转换为十六进制数
 */

// @lc code=start
class Solution {
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }

        StringBuilder builder = new StringBuilder();

        while (num != 0) {
            int hex = num & 0xF;
            num = num >>> 4;

            char c = getHex(hex);
            builder.append(c);
        }

        return builder.reverse().toString();
    }

    private char getHex(int num) {
        if (num < 10) {
            return (char) ('0' + num);
        } else {
            return (char) ('a' + (num - 10));
        }
    }
}
// @lc code=end

