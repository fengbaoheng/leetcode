/*
 * @lc app=leetcode.cn id=869 lang=java
 *
 * [869] 重新排序得到 2 的幂
 */

// @lc code=start
class Solution {
    // 获取所有2的幂
    private static final int[][] POWERS = new int[32][10];
    static {
        for (int i = 0; i < 32; i++) {
            int num = (int) Math.pow(2, i);
            POWERS[i] = getDigit(num);
        }
    }

    public boolean reorderedPowerOf2(int N) {
        int[] digit = getDigit(N);
        for (int i = 0; i < 32; i++) {
            if (isDigitEquals(digit, POWERS[i])) {
                return true;
            }
        }
        return false;
    }

    private static boolean isDigitEquals(int[] a, int[] b) {
        for (int i = 0; i < 10; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    private static int[] getDigit(int num) {
        int[] digit = new int[10];

        while (num != 0) {
            int i = num % 10;
            num /= 10;
            digit[i]++;
        }

        return digit;
    }
}
// @lc code=end

