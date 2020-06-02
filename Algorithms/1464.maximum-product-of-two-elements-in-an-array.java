/*
 * @lc app=leetcode.cn id=1464 lang=java
 *
 * [1464] 数组中两元素的最大乘积
 */

// @lc code=start
import java.util.*;

class Solution {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int a = nums[n - 1];
        int b = nums[n - 2];
        return (a - 1) * (b - 1);
    }
}
// @lc code=end

