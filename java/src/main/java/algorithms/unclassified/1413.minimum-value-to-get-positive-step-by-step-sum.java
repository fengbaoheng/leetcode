/*
 * @lc app=leetcode.cn id=1413 lang=java
 *
 * [1413] 逐步求和得到正数的最小值
 */

// @lc code=start
class Solution {
    public int minStartValue(int[] nums) {
        int sum = 0;
        int min = Integer.MAX_VALUE;

        for (int num : nums) {
            sum += num;
            min = Math.min(min, sum);
        }

        return Math.max(1, 1 - min);
    }
}
// @lc code=end
