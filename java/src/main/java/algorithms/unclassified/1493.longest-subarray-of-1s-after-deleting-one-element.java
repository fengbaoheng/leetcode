/*
 * @lc app=leetcode.cn id=1493 lang=java
 *
 * [1493] 删掉一个元素以后全为 1 的最长子数组
 */

// @lc code=start
class Solution {
    public int longestSubarray(int[] nums) {
        int maxLen = 0;
        int p = 0, q = 0;
        int pZeros = 0, qZeros = 0, diffZeros = 0;

        for (; q < nums.length; q++) {
            int num = nums[q];
            if (num == 0) {
                qZeros++;
                while ((diffZeros = qZeros - pZeros) > 1) {
                    if (nums[p++] == 0) {
                        pZeros++;
                    }
                }
            }
            int len = q - p + 1 - diffZeros;
            maxLen = Math.max(maxLen, len);
        }

        if (qZeros == 0) {
            maxLen--;
        }
        return maxLen;
    }
}
// @lc code=end

