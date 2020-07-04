/*
 * @lc app=leetcode.cn id=768 lang=java
 *
 * [768] 最多能完成排序的块 II
 */

// @lc code=start
class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return n;
        }
        
        // 计算i位置右侧的最小值
        int[] rightMin = new int[n];
        rightMin[n - 1] = Integer.MAX_VALUE;
        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], arr[i + 1]);
        }

        int leftMax = 0;
        int chunks = 0;
        for (int i = 0; i < n; i++) {
            leftMax = Math.max(leftMax, arr[i]);
            // 如果右侧还有更小的数，则需继续向右扩展
            // 否则到此为止可以作为独立的一块
            if (leftMax <= rightMin[i]) {
                chunks++;
            }
        }

        return chunks;
    }
}
// @lc code=end

