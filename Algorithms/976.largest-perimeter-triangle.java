/*
 * @lc app=leetcode.cn id=976 lang=java
 *
 * [976] 三角形的最大周长
 */

// @lc code=start
import java.util.*;


class Solution {
    public int largestPerimeter(int[] A) {
        int n = A.length;
        Arrays.sort(A);

        int a, b, c;
        for (int i = n - 3; i >= 0; i--) {
            a = A[i];
            b = A[i + 1];
            c = A[i + 2];
            if (a + b > c) {
                return a + b + c;
            }
        }

        return 0;
    }
}
// @lc code=end

