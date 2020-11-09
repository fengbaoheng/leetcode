/*
 * @lc app=leetcode.cn id=1646 lang=java
 *
 * [1646] 获取生成数组中的最大值
 */

// @lc code=start
class Solution {
    public int getMaximumGenerated(int n) {
        if (n <= 1) {
            return n;
        }

        int[] arr = new int[n + 1];
        arr[1] = 1;
        int max = 1;
        for (int i = 0; i < n + 1; i++) {
            int i2 = i + i;
            if (i2 <= n) {
                arr[i2] = arr[i];
            }

            if (i2 + 1 <= n) {
                arr[i2 + 1] = arr[i] + arr[i + 1];
                max = Math.max(max, arr[i2 + 1]);
            }

        }

        return max;
    }
}
// @lc code=end

