/*
 * @lc app=leetcode.cn id=633 lang=java
 *
 * [633] 平方数之和
 */

// @lc code=start
class Solution {
    public boolean judgeSquareSum(int c) {
        int mid = (int) Math.ceil(Math.sqrt(c));

        // 自身的平方根为最大上限即 c = 0^2 + sqrt(c)^ 2
        for (int i = mid; i >= 0; i--) {
            int squareI = i * i;
            for (int j = mid; j >= i; j--) {
                int squareSum = squareI + j * j;
                if (squareSum == c) {
                    return true;
                } else if (squareSum < c) {
                    break;
                }
            }
        }

        return false;
    }
}
// @lc code=end

