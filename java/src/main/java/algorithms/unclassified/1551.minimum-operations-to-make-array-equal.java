/*
 * @lc app=leetcode.cn id=1551 lang=java
 *
 * [1551] 使数组中所有元素相等的最小操作数
 */

// @lc code=start
class Solution {
    public int minOperations(int n) {
        int count = 0;
        int i = 1;
        while (i < n) {
            count += n - i;
            i += 2;
        }

        return count;
    }
}
// @lc code=end

