/*
 * @lc app=leetcode.cn id=780 lang=java
 *
 * [780] 到达终点
 */
class Solution {
    // 从终点向起点逆推: (x,y) = (x , y-x) || (x-y, y)
    // 但输入的x,y>=1, 因此:
    // 当 x > y 时 上一个点为(x-y, y)
    // 当 y > x 时,上个点为(x, y-x)
    // 当tx和ty相差较大时, 可以一次减去多个
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        int count = 0;

        while (tx > 0 && ty > 0) {
            if (tx == sx && ty == sy) {
                return true;
            }

            if (tx > ty) {
                // 防止直接减到0, 如 3, 3, 6, 3
                count = Math.max((tx - sx) / ty, 1);
                tx -= count * ty;

            } else {
                count = Math.max((ty - sy) / tx, 1);
                ty -= count * tx;
            }
        }

        return false;
    }
}

