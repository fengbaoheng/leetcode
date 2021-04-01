/*
 * @lc app=leetcode.cn id=507 lang=java
 *
 * [507] 完美数
 */

// @lc code=start
class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num <= 1) {
            return false;
        }

        int sqrt = (int) Math.sqrt(num);
        int sum = 1;
        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0) {
                sum += i;

                int j = num / i;
                if (i != j) {
                    sum += j;
                }
            }
        }

        return sum == num;
    }
}
// @lc code=end

