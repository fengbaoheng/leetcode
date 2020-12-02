/*
 * @lc app=leetcode.cn id=674 lang=java
 *
 * [674] 最长连续递增序列
 */

// @lc code=start
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int count = 0;

        int start = 0;
        for (int i = 1; i < nums.length; i++) {
            int pre = nums[i - 1];
            int cur = nums[i];

            if (cur <= pre) {
                count = Math.max(count, i - start);
                start = i;
            }
        }

        count = Math.max(count, nums.length - start);

        return count;
    }
}
// @lc code=end

