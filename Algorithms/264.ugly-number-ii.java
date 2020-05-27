/*
 * @lc app=leetcode.cn id=264 lang=java
 *
 * [264] 丑数 II
 */

// @lc code=start
class Solution {
    public int nthUglyNumber(int n) {
        int[] nums = new int[n + 1];
        nums[1] = 1;

        int i2 = 1, i3 = 1, i5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = nums[i2] * 2;
            int num3 = nums[i3] * 3;
            int num5 = nums[i5] * 5;

            int num = Math.min(num2, Math.min(num3, num5));

            if (num == num2) {
                i2++;
            }

            if (num == num3) {
                i3++;
            }

            if (num == num5) {
                i5++;
            }

            nums[i] = num;
        }

        return nums[n];
    }
}
// @lc code=end

