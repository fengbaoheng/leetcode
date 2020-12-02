/*
 * @lc app=leetcode.cn id=718 lang=java
 *
 * [718] 最长重复子数组
 */

// @lc code=start
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    // 动态规划
    public int findLength(int[] A, int[] B) {
        // 记录坐标快速定位
        Map<Integer, Set<Integer>> mapB = new HashMap<>(B.length);
        for (int i = 0; i < B.length; i++) {
            mapB.computeIfAbsent(B[i], k -> new HashSet<>()).add(i);
        }

        int[][] dp = new int[A.length][B.length];

        int maxLength = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            Set<Integer> set = mapB.get(A[i]);
            if (set == null) {
                continue;
            }

            for (int j : set) {
                dp[i][j] = 1;
                if (i + 1 < A.length && j + 1 < B.length) {
                    // 转移方程
                    dp[i][j] += dp[i + 1][j + 1];

                }

                maxLength = Math.max(maxLength, dp[i][j]);
            }
        }


        return maxLength;
    }

}
// @lc code=end

