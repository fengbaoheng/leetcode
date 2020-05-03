/*
 * @lc app=leetcode.cn id=696 lang=java
 *
 * [696] 计数二进制子串
 */

// @lc code=start
class Solution {
    public int countBinarySubstrings(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }

        int result = 0;
        int[] count = {0, 0};
        int pre = 0;
        for (char c : s.toCharArray()) {
            int cur = c - '0';
            int opp = (cur + 1) % 2;

            count[cur] = cur == pre ? count[cur] + 1 : 1;
            if (count[cur] <= count[opp]) {
                result++;
            }

            pre = cur;
        }

        return result;
    }
}
// @lc code=end

