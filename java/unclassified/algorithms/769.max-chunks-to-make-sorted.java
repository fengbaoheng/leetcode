/*
 * @lc app=leetcode.cn id=769 lang=java
 *
 * [769] 最多能完成排序的块
 */

// @lc code=start
class Solution {
    public int maxChunksToSorted(int[] arr) {
        int right = 0;
        int chunks = 0;
        for (int i = 0; i < arr.length; i++) {
            right = Math.max(right, arr[i]);
            if (right <= i) {
                chunks++;
            }
        }
        return chunks;
    }
}
// @lc code=end

