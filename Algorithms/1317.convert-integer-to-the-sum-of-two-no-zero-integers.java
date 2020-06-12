/*
 * @lc app=leetcode.cn id=1317 lang=java
 *
 * [1317] 将整数转换为两个无零整数的和
 */

// @lc code=start
class Solution {
    public int[] getNoZeroIntegers(int n) {
        for (int i = 1; i < n; i++) {
            if (!hasZero(i) && !hasZero(n - i)) {
                return new int[]{i, n - i};
            }
        }
        return new int[2];
    }

    private boolean hasZero(int x) {
        if (x == 0) {
            return true;
        }
        while (x != 0) {
            if (x % 10 == 0) {
                return true;
            }
            x /= 10;
        }
        return false;
    }
}
// @lc code=end

