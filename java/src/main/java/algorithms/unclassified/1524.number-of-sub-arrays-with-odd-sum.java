/*
 * @lc app=leetcode.cn id=1524 lang=java
 *
 * [1524] 和为奇数的子数组数目
 */

// @lc code=start
class Solution {
    private final int MOD = (int) (1e9 + 7);

    public int numOfSubarrays(int[] arr) {
        // 前缀[0-i]的和为奇数和偶数的个数
        // 特殊情况：空数组累计和为0是偶数
        int countEven = 1;
        int countOdd = 0;

        // 前缀累积和
        int acc = 0;

        long result = 0;
        for (int num : arr) {
            acc += num;
            if (acc % 2 == 0) {
                result += countOdd;
                countEven++;
            } else {
                result += countEven;
                countOdd++;
            }

            result %= MOD;
        }

        return (int) result;
    }
}
// @lc code=end

