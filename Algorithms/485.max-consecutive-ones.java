/*
 * @lc app=leetcode.cn id=485 lang=java
 *
 * [485] 最大连续1的个数
 */
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxCount = 0;
        int tmpCount = 0;

        for (int num : nums) {
            if (num == 1) {
                tmpCount++;
            } else {
                maxCount = tmpCount > maxCount ? tmpCount : maxCount;
                tmpCount = 0;
            }
        }

        // 可能数组最后一位是连续的1
        maxCount = tmpCount > maxCount ? tmpCount : maxCount;

        return maxCount;
    }
}
