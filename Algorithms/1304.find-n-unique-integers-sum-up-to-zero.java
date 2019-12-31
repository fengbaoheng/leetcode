/*
 * @lc app=leetcode.cn id=1304 lang=java
 *
 * [1304] 和为零的N个唯一整数
 */

// @lc code=start
class Solution {
    public int[] sumZero(int n) {
        int[] results = new int[n];

        // 奇数长度,最后一个数字为0
        if (n % 2 != 0) {
            n--;
        }

        // 偶数个数字成对组成和为0
        for (int i = 1; i < n; i += 2) {
            results[i - 1] = -i;
            results[i] = i;
        }

        return results;
    }
}
// @lc code=end

