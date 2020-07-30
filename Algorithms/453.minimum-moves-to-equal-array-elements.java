/*
 * @lc app=leetcode.cn id=453 lang=java
 *
 * [453] 最小移动次数使数组元素相等
 */

// @lc code=start
class Solution {
    // 逆向思维，让n-1个数增加就是让某个数减少
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num < min) {
                min = num;
            }
        }

        int count = 0;
        for (int num : nums) {
            count += (num - min);
        }
        return count;
    }
}
// @lc code=end

