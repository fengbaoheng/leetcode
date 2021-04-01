/*
 * @lc app=leetcode.cn id=213 lang=java
 *
 * [213] 打家劫舍 II
 */

// @lc code=start
import java.util.*;


class Solution {
    // 拆分为两个动态规划
    // 1. 决定是否偷第0户
    // 2. 中间房屋相邻最大
    public int rob(int[] nums) {
        int len = nums.length;

        if (len == 0) {
            return 0;
        } else if (len == 1) {
            return nums[0];
        } else if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int start, end;

        // 选择不偷第0户
        // 可以偷第1户到len-1户
        start = 1;
        end = len;
        int notRobFirst = robNotCircle(Arrays.copyOfRange(nums, start, end));


        // 选择偷第0户
        // 则第1户和len-1户都不能偷
        start = 2;
        end = len - 1;
        int robFirst = nums[0] + robNotCircle(Arrays.copyOfRange(nums, start, end));

        return Math.max(notRobFirst, robFirst);
    }


    // 仅在不偷相邻的约束下, 最大偷窃数额
    private int robNotCircle(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        } else if (len == 1) {
            return nums[0];
        } else if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }

        nums[1] = Math.max(nums[0], nums[1]);

        // 长度一定大于2
        for (int i = 2; i < nums.length; i++) {
            int robCur = nums[i] + nums[i - 2];
            int robLeft = nums[i - 1];

            nums[i] = Math.max(robCur, robLeft);
        }

        return nums[len - 1];
    }
}
// @lc code=end

