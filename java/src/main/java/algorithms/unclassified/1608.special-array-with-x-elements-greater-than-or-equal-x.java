/*
 * @lc app=leetcode.cn id=1608 lang=java
 *
 * [1608] 特殊数组的特征值
 */

// @lc code=start
import java.util.Arrays;

class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);

        for (int x = nums.length; x > 0; x--) {
            int i = nums.length - x;
            if (nums[i] >= x) {
                if (i == 0) {
                    return x;
                }

                if (nums[i - 1] < x) {
                    return x;
                }
            }
        }
        return -1;
    }
}
// @lc code=end

