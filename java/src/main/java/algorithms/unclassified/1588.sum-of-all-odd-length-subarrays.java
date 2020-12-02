/*
 * @lc app=leetcode.cn id=1588 lang=java
 *
 * [1588] 所有奇数长度子数组的和
 */

// @lc code=start
class Solution {

    public int sumOddLengthSubarrays(int[] arr) {
        int oddSum = 0;
        int[] sum = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            // 计算累积和
            sum[i] = (i > 0 ? sum[i - 1] : 0) + arr[i];

            for (int j = i - 1; j >= -1; j -= 2) {
                oddSum += sum[i] - (j == -1 ? 0 : sum[j]);
            }
        }

        return oddSum;
    }

}
// @lc code=end

