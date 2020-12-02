/*
 * @lc app=leetcode.cn id=1437 lang=java
 *
 * [1437] 是否所有 1 都至少相隔 k 个元素
 */

// @lc code=start
class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int last = -1;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (num == 0) {
                continue;
            }

            int internal = (i - last - 1);
            if (last == -1 || internal >= k) {
                last = i;
            } else {
                return false;
            }
        }

        return true;
    }
}
// @lc code=end

