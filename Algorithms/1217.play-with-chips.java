/*
 * @lc app=leetcode.cn id=1217 lang=java
 *
 * [1217] 玩筹码
 */

// @lc code=start
class Solution {
    // 所有偶数位置可以花费0代价移动到同一个位置
    // 所有奇数位置可以花费0代价移动到同一个位置
    // 两堆奇偶筹码可以花费0代价移动到相邻的位置
    // 此时花费min(偶数筹码, 奇数筹码)代价可将两堆筹码移动到一起
    public int minCostToMoveChips(int[] chips) {
        int oddCount = 0;
        int evenCount = 0;

        for (int chip : chips) {
            if (chip % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        return Math.min(oddCount, evenCount);
    }
}
// @lc code=end

