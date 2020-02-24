/*
 * @lc app=leetcode.cn id=717 lang=java
 *
 * [717] 1比特与2比特字符
 */

// @lc code=start
class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int size = bits.length;

        // 仅有1个字符
        if (size <= 1) {
            return true;
        }

        // 仅有2个字符
        if (size == 2) {
            return bits[0] == 0;
        }


        // 超过2字符
        if (bits[size - 2] == 0) {
            return true;
        }

        // canEnd[i]: 能否在第i个字符处结束
        boolean[] canEnd = new boolean[size];
        canEnd[0] = bits[0] == 0;
        canEnd[1] = bits[0] == 1 || bits[1] == 0;

        // 依次向后判断
        for (int i = 2; i < size; i++) {
            int cur = bits[i];
            boolean preCanEnd = canEnd[i - 1];

            if (!preCanEnd) {
                // 一定和前一个字符组合，并能在当前字符结束
                canEnd[i] = true;
            } else {
                // 当前字符若为0,则可结束
                // 否则一定不会结束必然和下一个字符组合
                canEnd[i] = cur == 0;
            }

        }


        // 倒数第3个必须和倒数第2个字符组合
        return !canEnd[size - 3];
    }
}
// @lc code=end

