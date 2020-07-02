/*
 * @lc app=leetcode.cn id=1014 lang=java
 *
 * [1014] 最佳观光组合
 */

// @lc code=start
class Solution {
    public int maxScoreSightseeingPair(int[] A) {
        int left = 0;
        int maxScore = 0;

        for (int val : A) {
            left--;
            maxScore = Math.max(maxScore, left + val);
            left = Math.max(left, val);
        }

        return maxScore;
    }
}
// @lc code=end

