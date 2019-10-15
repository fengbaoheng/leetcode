/*
 * @lc app=leetcode.cn id=5222 lang=java
 *
 * [5222] 分割平衡字符串
 */

// @lc code=start
class Solution {
    public int balancedStringSplit(String s) {
        int count = 0;
        int balance = 0;

        for (char c : s.toCharArray()) {
            balance += c == 'L' ? -1 : 1;
            if (balance == 0) {
                count++;
            }
        }

        return count;
    }
}
// @lc code=end

