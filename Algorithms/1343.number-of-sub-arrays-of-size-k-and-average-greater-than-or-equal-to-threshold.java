/*
 * @lc app=leetcode.cn id=1343 lang=java
 *
 * [1343] 大小为 K 且平均值大于等于阈值的子数组数目
 */

// @lc code=start
class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        int thresholdK = k * threshold;
        int count = sum >= thresholdK ? 1 : 0;

        for (int i = k; i < n; i++) {
            sum = sum + arr[i] - arr[i - k];
            if (sum >= thresholdK) {
                count++;
            }
        }
        return count;
    }
}
// @lc code=end

