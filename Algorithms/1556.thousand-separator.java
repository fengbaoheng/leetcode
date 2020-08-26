/*
 * @lc app=leetcode.cn id=1556 lang=java
 *
 * [1556] 千位分隔数
 */

// @lc code=start
class Solution {
    public String thousandSeparator(int n) {
        if (n == 0) {
            return "0";
        }

        StringBuilder builder = new StringBuilder();

        int count = 0;
        while (n != 0) {
            builder.append(n % 10);
            n /= 10;

            count++;
            if (count % 3 == 0 && n != 0) {
                builder.append('.');
            }
        }
        builder.reverse();
        return builder.toString();
    }
}
// @lc code=end

