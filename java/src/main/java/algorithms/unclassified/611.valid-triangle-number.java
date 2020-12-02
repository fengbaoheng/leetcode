/*
 * @lc app=leetcode.cn id=611 lang=java
 *
 * [611] 有效三角形的个数
 */

// @lc code=start
import java.util.Arrays;

class Solution {
    public int triangleNumber(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }


        Arrays.sort(nums);

        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                for (int k = j + 1; k < nums.length && sum > nums[k]; k++) {
                    count++;
                }
            }
        }

        return count;
    }
}
// @lc code=end

