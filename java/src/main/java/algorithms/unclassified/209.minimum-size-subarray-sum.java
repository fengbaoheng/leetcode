/*
 * @lc app=leetcode.cn id=209 lang=java
 *
 * [209] 长度最小的子数组
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;

        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        int pre = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];

            if (sum >= s) {
                while (pre <= i && sum >= s) {
                    minLen = Math.min(minLen, i - pre + 1);
                    sum -= nums[pre];
                    pre++;
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
// @lc code=end
