/*
 * @lc app=leetcode.cn id=1362 lang=java
 *
 * [1362] 最接近的因数
 */

// @lc code=start
class Solution {
    public int[] closestDivisors(int num) {
        int[] r1 = close(num + 1);
        int[] r2 = close(num + 2);

        int d1 = Math.abs(r1[0] - r1[1]);
        int d2 = Math.abs(r2[0] - r2[1]);

        return d1 < d2 ? r1 : r2;
    }

    private int[] close(int num) {
        int sqrt = (int) Math.sqrt(num);
        while (true) {
            if (num % sqrt == 0) {
                return new int[]{sqrt, num / sqrt};
            }
            sqrt--;
        }
    }
}
// @lc code=end