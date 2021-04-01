/*
 * @lc app=leetcode.cn id=1545 lang=java
 *
 * [1545] 找出第 N 个二进制字符串中的第 K 位
 */

// @lc code=start
class Solution {
    // 计算好每一层的长度
    private static final int[] LEN = new int[21];
    static {
        LEN[1] = 1;
        for (int i = 2; i <= 20; i++) {
            LEN[i] = 2 * LEN[i - 1] + 1;
        }
    }

    public char findKthBit(int n, int k) {
        // 是否翻转过
        boolean isInverted = false;

        while (true) {
            if (k == 1) {
                return isInverted ? '1' : '0';
            }

            int len = LEN[n];

            // 恰好是中间的1
            if (k - 1 == len / 2) {
                return isInverted ? '0' : '1';
            }

            // 在右边，需要转换为上一层的k值
            if (k > len / 2) {
                isInverted = !isInverted;
                int preLen = LEN[n - 1];
                k = k - 1 - preLen;
                k = preLen - k + 1;
            }

            // 向上一层迭代
            n--;
        }
    }
}
// @lc code=end

