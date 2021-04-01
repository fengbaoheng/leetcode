/*
 * @lc app=leetcode.cn id=1332 lang=java
 *
 * [1332] 删除回文子序列
 */

// @lc code=start
class Solution {
    public int removePalindromeSub(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }

        // 本身回文 只需一次
        String reversed = new StringBuilder(s).reverse().toString();
        if (reversed.equals(s)) {
            return 1;
        }

        // 最多两次删完
        return 2;
    }
}
// @lc code=end

