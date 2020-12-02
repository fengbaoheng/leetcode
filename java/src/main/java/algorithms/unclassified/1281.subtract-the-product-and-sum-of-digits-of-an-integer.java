/*
 * @lc app=leetcode.cn id=1281 lang=java
 *
 * [1281] 整数的各位积和之差
 */

// @lc code=start
class Solution {
    public int subtractProductAndSum(int n) {

        int sum = 0;
        int product = 1;

        while (n != 0) {
            int d = n % 10;
            n = n / 10;

            sum += d;
            product *= d;
        }


        return product - sum;
    }
}
// @lc code=end

