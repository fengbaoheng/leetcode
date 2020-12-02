/*
 * @lc app=leetcode.cn id=1446 lang=java
 *
 * [1446] 连续字符
 */

// @lc code=start
class Solution {
    public int maxPower(String s) {
        int max = 0;
        int count = 0;
        char pre = ' ';

        for (char c : s.toCharArray()) {
            if (c == pre) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 1;
                pre = c;
            }
        }

        max = Math.max(max, count);

        return max;
    }
}
// @lc code=end

