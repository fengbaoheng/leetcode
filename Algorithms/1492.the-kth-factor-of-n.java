/*
 * @lc app=leetcode.cn id=1492 lang=java
 *
 * [1492] n 的第 k 个因子
 */

// @lc code=start
class Solution {
    public int kthFactor(int n, int k) {
        for (int i = 1; i <= n; i++) {
            if (n % i == 0 && --k == 0) {
                return i;
            }
        }

        return -1;
    }
}
// @lc code=end

