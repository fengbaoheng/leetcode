/*
 * @lc app=leetcode.cn id=357 lang=java
 *
 * [357] 计算各个位数不同的数字个数
 */

// @lc code=start
import java.util.stream.IntStream;

class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        return IntStream.rangeClosed(1, n).map(this::count).sum();
    }

    private int count(int n) {
        if (n == 1) {
            return 10;
        }

        int result = 9;
        for (int i = 2; i <= n; i++) {
            result *= (11 - i);
        }
        return result;
    }
}
// @lc code=end

