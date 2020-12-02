/*
 * @lc app=leetcode.cn id=1470 lang=java
 *
 * [1470] 重新排列数组
 */

// @lc code=start
class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] arr = new int[n + n];

        for (int i = 0; i < n; i++) {
            arr[i + i] = nums[i];
            arr[i + i + 1] = nums[n + i];
        }

        return arr;
    }
}
// @lc code=end

