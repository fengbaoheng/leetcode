/*
 * @lc app=leetcode.cn id=643 lang=java
 *
 * [643] 子数组最大平均数 I
 */

// @lc code=start
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        // 最大和 / k
        return findMax(nums, k) / (double) k;
    }

    // 滑动窗口求最大子数组的和
    public int findMax(int[] nums, int k) {
        int len = nums.length;

        int sum = 0;

        // 先进行累加
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        // 滑动求和
        int max = sum;
        for (int i = k; i < len; i++) {
            int pop = nums[i - k];
            int push = nums[i];

            sum = sum - pop + push;
            max = Math.max(max, sum);
        }

        return max;
    }
}
// @lc code=end

