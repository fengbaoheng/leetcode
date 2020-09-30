/*
 * @lc app=leetcode.cn id=477 lang=java
 *
 * [477] 汉明距离总和
 */

// @lc code=start
class Solution {
    public int totalHammingDistance(int[] nums) {
        int[] countZero = new int[32], countOne = new int[32];

        for (int num : nums) {
            count(num, countZero, countOne);
        }

        // 按位计算累计和
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += countOne[i] * countZero[i];
        }

        return result;
    }

    private void count(int num, int[] countZero, int[] countOne) {
        // 32位整数范围内，逐位计数累计
        for (int i = 0; i < 32; i++) {
            int c = num & (1 << i);
            if (c == 0) {
                countZero[i]++;
            } else {
                countOne[i]++;
            }
        }
    }
}
// @lc code=end

