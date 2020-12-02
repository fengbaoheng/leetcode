/*
 * @lc app=leetcode.cn id=1486 lang=java
 *
 * [1486] 数组异或操作
 */

// @lc code=start
class Solution {
    public int xorOperation(int n, int start) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = result ^ (start + i + i);
        }

        return result;
    }
}
// @lc code=end

