/*
 * @lc app=leetcode.cn id=1318 lang=java
 *
 * [1318] 或运算的最小翻转次数
 */

// @lc code=start
class Solution {
    public int minFlips(int a, int b, int c) {
        int[] bitsA = getBits(a);
        int[] bitsB = getBits(b);
        int[] bitsC = getBits(c);

        int count = 0;
        for (int i = 0; i < 32; i++) {
            int bitA = bitsA[i];
            int bitB = bitsB[i];
            int bitC = bitsC[i];

            if (bitC == 1) {
                if (bitA + bitB == 0) {
                    count++;
                }
            } else {
                count += bitA;
                count += bitB;
            }
        }
        return count;
    }

    private int[] getBits(int num) {
        int[] bits = new int[32];
        for (int i = 0; i < 32; i++) {
            bits[i] = num & 1;
            num = num >>> 1;
        }
        return bits;
    }
}
// @lc code=end

