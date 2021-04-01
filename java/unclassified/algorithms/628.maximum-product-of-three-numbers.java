/*
 * @lc app=leetcode.cn id=628 lang=java
 *
 * [628] 三个数的最大乘积
 */

// @lc code=start
class Solution {
    // 最大乘积考虑 负负正, 正正正, 负正正
    public int maximumProduct(int[] nums) {
        int min1, min2;
        min1 = min2 = Integer.MAX_VALUE;

        int max1, max2, max3;
        max1 = max2 = max3 = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }

            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }
        }

        int r1 = max3 * max2 * max1;
        int r2 = min1 * min2 * max1;
        int r3 = min1 * max1 * max2;

        return Math.max(r1, Math.max(r2, r3));
    }
}
// @lc code=end

