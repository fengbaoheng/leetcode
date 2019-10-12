/*
 * @lc app=leetcode.cn id=367 lang=java
 *
 * [367] 有效的完全平方数
 */

// @lc code=start
class Solution {
    // 二分查找平方根
    // 乘法计算平方数会溢出, 可反向用除法计算
    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }

        int p = 1, q = num - 1;

        while (p <= q) {
            int m = Math.floorDiv(p + q, 2);
            double d = (double) num / m;
            int compare = Double.compare(m, d);

            if (compare == 0) {
                return true;
            } else if (compare < 0) {
                p = m + 1;
            } else {
                q = m - 1;
            }
        }

        return false;
    }
}
// @lc code=end

