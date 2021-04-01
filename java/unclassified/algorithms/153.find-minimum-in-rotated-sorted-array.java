/*
 * @lc app=leetcode.cn id=153 lang=java
 *
 * [153] 寻找旋转排序数组中的最小值
 */
class Solution {
    public int findMin(int[] nums) {

        int length = nums.length;

        // 没有发生旋转(最小值在0) 或 仅有一个数
        if (nums[0] <= nums[length - 1]) {
            return nums[0];
        }

        // 肯定发生了旋转
        // 二分查找
        int p = 1, q = length - 1;
        
        // nums[0]作为区分前段数组后段数组的比较数字
        int midValue = nums[0];

        do {
            int m = (p + q) / 2;
            int pre = nums[m - 1];
            int cur = nums[m];

            if (cur < pre) {
                return cur;
            }

            // 通过与第一个值比较确定向先或向后搜索
            if (cur >= midValue) {
                p = m + 1;
            } else {
                q = m - 1;
            }

        } while (true);
    }
}
