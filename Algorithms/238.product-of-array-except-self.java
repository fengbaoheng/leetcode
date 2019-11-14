/*
 * @lc app=leetcode.cn id=238 lang=java
 *
 * [238] 除自身以外数组的乘积
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;

        // i左侧累积乘积, 不包含nums[i]
        int[] leftSum = new int[len];
        leftSum[0] = 1;
        for (int i = 1; i < len; i++) {
            leftSum[i] = leftSum[i - 1] * nums[i - 1];
        }
        
        // i右侧累积乘积, 不包含nums[i]
        int[] rightSum = new int[len];
        rightSum[len - 1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            rightSum[i] = rightSum[i + 1] * nums[i + 1];
        }

        // i左侧累积 * i右侧累积
        int[] result = new int[len];
        for (int i = 0; i < result.length; i++) {
            result[i] = leftSum[i] * rightSum[i];
        }

        return result;
    }
}
// @lc code=end

