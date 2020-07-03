/*
 * @lc app=leetcode.cn id=991 lang=java
 *
 * [991] 坏了的计算器
 */

// @lc code=start
class Solution {
    /**
     * 反转思想
     * X->Y：双倍，递减
     * Y->X: 折半，递增
     */
    public int brokenCalc(int X, int Y) {
        int count = 0;
        while (Y != X) {
            if (Y < X) {
                count += X - Y;
                break;
            }

            if (Y % 2 == 0) {
                Y /= 2;
            } else {
                Y++;
            }
            count++;
        }
        return count;
    }
}
// @lc code=end

