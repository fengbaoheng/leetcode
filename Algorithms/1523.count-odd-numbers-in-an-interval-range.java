/*
 * @lc app=leetcode.cn id=1523 lang=java
 *
 * [1523] 在区间范围内统计奇数数目
 */

// @lc code=start
class Solution {
    public int countOdds(int low, int high) {
        if (low % 2 == 1) {
            low--;
        }

        if (high % 2 == 1) {
            high++;
        }

        // 计算两个偶数之间的奇数个数
        return (high - low) / 2;
    }
}
// @lc code=end

