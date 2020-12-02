/*
 * @lc app=leetcode.cn id=334 lang=java
 *
 * [334] 递增的三元子序列
 */

// @lc code=start
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return false;
        }

        // 最小值
        int min = nums[0];

        // 中值
        int medium = Integer.MAX_VALUE;

        for (int num : nums) {
            // 符合条件直接返回
            if (num > medium) {
                return true;
            }

            // 若当前值比最小值还要小，则继续刷新最小值下限
            // 但是此时的中值仍旧保留
            if (num <= min) {
                min = num;
            } else if (num <= medium) {
                // 刷新更小的中值
                medium = num;
            }
        }

        return false;
    }
}
// @lc code=end

