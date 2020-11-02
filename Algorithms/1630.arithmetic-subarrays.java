/*
 * @lc app=leetcode.cn id=1630 lang=java
 *
 * [1630] 等差子数组
 */

// @lc code=start
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> result = new LinkedList<>();

        int len = l.length;
        for (int i = 0; i < len; i++) {
            result.add(isArithmetic(getNums(nums, l[i], r[i])));
        }

        return result;
    }

    // 截取部分数组
    private int[] getNums(int[] nums, int start, int end) {
        int len = end - start + 1;
        int[] arr = new int[len];
        System.arraycopy(nums, start, arr, 0, len);
        return arr;
    }

    // 判断数组
    private boolean isArithmetic(int[] nums) {
        int len = nums.length;
        if (len <= 2) {
            return true;
        }

        Arrays.sort(nums);

        int diff = nums[1] - nums[0];

        for (int i = 2; i < len; i++) {
            if (nums[i] - nums[i - 1] != diff) {
                return false;
            }
        }

        return true;
    }
}
// @lc code=end

