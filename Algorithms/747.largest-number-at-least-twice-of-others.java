/*
 * @lc app=leetcode.cn id=747 lang=java
 *
 * [747] 至少是其他数字两倍的最大数
 */

// @lc code=start
class Solution {
    public int dominantIndex(int[] nums) {
        int[] maxValue = {0, nums[0]};
        int[] doubleValue = {0, nums[0] * 2};

        int max = nums[0];
        int maxIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > max) {
                max = num;
                maxIndex = i;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (num * 2 > max && i != maxIndex) {
                return -1;
            }
        }

        return maxIndex;
    }
}
// @lc code=end

