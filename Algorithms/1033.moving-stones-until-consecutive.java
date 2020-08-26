/*
 * @lc app=leetcode.cn id=1033 lang=java
 *
 * [1033] 移动石子直到连续
 */

// @lc code=start
class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        int min = Math.min(a, Math.min(b, c));
        int max = Math.max(a, Math.max(b, c));
        int mid = a + b + c - min - max;

        return new int[] { getMin(min, mid, max), getMax(min, mid, max) };
    }

    // 最小步数即每次尽可能多的收缩区间
    private int getMin(int x, int y, int z) {
        int count = 0;

        while (z - x > 2) {
            // 计算四种可能的收缩结果
            int zShrink = y - 1 > x ? z - y : z - y - 1;
            int xShrink = y + 1 < z ? y - x : y - x - 1;

            // 更新收缩后的x y z
            if (zShrink > xShrink) {
                if (y - 1 > x) {
                    z = y;
                    y = y - 1;
                } else {
                    z = y + 1;
                }
            } else {
                if (y + 1 < z) {
                    x = y;
                    y = y + 1;
                } else {
                    x = y - 1;
                }
            }

            count++;
        }

        return count;
    }

    // 最大步数即每次只收缩1格区间
    private int getMax(int x, int y, int z) {
        return (y - x - 1) + (z - y - 1);
    }
}
// @lc code=end
