/*
 * @lc app=leetcode.cn id=1004 lang=java
 *
 * [1004] 最大连续1的个数 III
 */

// @lc code=start
class Solution {
    // 滑动窗口
    public int longestOnes(int[] A, int K) {
        int left = 0;
        int longest = 0;
        for (int right = 0; right < A.length; right++) {
            int num = A[right];

            if (num == 0) {
                if (K > 0) {
                    // 剩余反转机会，窗口直接向右扩展
                    K--;
                } else {
                    // 反转机会已用完，左侧收缩出1个0位
                    for (; left <= right; left++) {
                        if (A[left] == 0) {
                            left++;
                            break;
                        }
                    }
                }
            }
            
            // 计算新长度
            longest = Math.max(longest, right - left + 1);
        }

        return longest;
    }
}
// @lc code=end

