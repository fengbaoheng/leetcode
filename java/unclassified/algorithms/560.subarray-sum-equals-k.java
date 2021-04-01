/*
 * @lc app=leetcode.cn id=560 lang=java
 *
 * [560] 和为K的子数组
 */

// @lc code=start
import java.util.Arrays;

class Solution {
    public int subarraySum(int[] nums, int k) {
        final int n = nums.length;
        int[] sums = Arrays.copyOf(nums, n);
        for (int i = 1; i < n; i++) {
            sums[i] += sums[i - 1];
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (k == getSum(sums, i, j)) {
                    count++;
                }
            }
        }

        return count;
    }

    private int getSum(int[] sums, int i, int j) {
        if (i == 0) {
            return sums[j];
        }
        return sums[j] - sums[i-1];
    }
}
// @lc code=end

