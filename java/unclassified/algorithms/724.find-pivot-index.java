/*
 * @lc app=leetcode.cn id=724 lang=java
 *
 * [724] 寻找数组的中心索引
 */

// @lc code=start
import java.util.Arrays;

class Solution {
    public int pivotIndex(int[] nums) {
        if (nums.length < 3) {
            return -1;
        }

        // 计算前缀和
        int[] sum = Arrays.copyOf(nums, nums.length);
        for (int i = 1; i < sum.length; i++) {
            sum[i] += sum[i - 1];
        }

        int totalSum = sum[sum.length - 1];
        for (int i = 0; i < sum.length; i++) {
            int preSum = i > 0 ? sum[i - 1] : 0;
            int endSum = totalSum - sum[i];
            if (preSum == endSum) {
                return i;
            }
        }

        return -1;
    }
}
// @lc code=end

