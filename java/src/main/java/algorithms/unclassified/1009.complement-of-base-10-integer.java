/*
 * @lc app=leetcode.cn id=1009 lang=java
 *
 * [1009] 十进制整数的反码
 */

// @lc code=start
class Solution {
    public int bitwiseComplement(int N) {
        if(N == 0){
            return 1;
        }

        // 找到第一个1所在的位数
        int count = 0;
        int mask = N;
        while (mask != 0) {
            mask = mask >> 1;
            count++;
        }

        // 获取掩码 00000....11111
        mask = (1 << count) - 1;

        return (~N) & mask;
    }
}
// @lc code=end

