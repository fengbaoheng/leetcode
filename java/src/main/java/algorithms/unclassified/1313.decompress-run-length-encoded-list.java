/*
 * @lc app=leetcode.cn id=1313 lang=java
 *
 * [1313] 解压缩编码列表
 */

// @lc code=start
class Solution {
    public int[] decompressRLElist(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length; i += 2) {
            count += nums[i];
        }

        int[] result = new int[count];
        int p = 0;
        for (int i = 0; i < nums.length; i += 2) {
            int c = nums[i];
            int n = nums[i + 1];

            for (int j = 0; j < c; j++) {
                result[p] = n;
                p++;
            }
        }

        return result;
    }
}
// @lc code=end

