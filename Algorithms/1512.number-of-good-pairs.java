/*
 * @lc app=leetcode.cn id=1512 lang=java
 *
 * [1512] 好数对的数目
 */

// @lc code=start
class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] count = new int[101];
        for (int num : nums) {
            count[num]++;
        }

        int result = 0;

        for (int i = 0; i < 101; i++) {
            int c = count[i];
            if (c > 1) {
                result += c * (c - 1) / 2;
            }
        }

        return result;
    }
}
// @lc code=end

