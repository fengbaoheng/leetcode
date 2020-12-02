/*
 * @lc app=leetcode.cn id=581 lang=java
 *
 * [581] 最短无序连续子数组
 */

// @lc code=start
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if (isSorted(nums)) {
            return 0;
        }

        // 找到两边界即可
        return getRight(nums) - getLeft(nums) + 1;
    }

    /**
     * 是否已经有序
     */
    private boolean isSorted(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 左边界第一个不合法的数字
     * 即存在 k > 0 使 nums[i] > nums[i + k]
     */
    private int getLeft(int[] nums) {
        // 从右向左遍历,记录遍历到的最小值
        int min = Integer.MAX_VALUE;
        int left = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > min) {
                // i位置不合法
                left = i;
            } else {
                min = nums[i];
            }
        }

        return left;
    }

    /**
     * 右边界第一个不合法的数字
     * 即存在 k > 0 使 nums[i - k] > nums[i]
     */
    private int getRight(int[] nums) {
        // 从左向右遍历,记录遍历到的最大值
        int max = Integer.MIN_VALUE;
        int right = -1;
        for (int i = 0; i < nums.length; i++) {
            if (max > nums[i]) {
                // i位置不合法
                right = i;
            } else {
                max = nums[i];
            }
        }

        return right;
    }
}
// @lc code=end

