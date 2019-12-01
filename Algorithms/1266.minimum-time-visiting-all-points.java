/*
 * @lc app=leetcode.cn id=1266 lang=java
 *
 * [1266] 访问所有点的最小时间
 */

// @lc code=start
class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int time = 0;
        // 起始点
        int[] from = points[0];

        // 依次迭代点累积时间总和
        for (int[] point : points) {
            time += getTime(from, point);
            from = point;
        }

        return time;
    }

    // 尽可能沿着斜边走

    private int getTime(int[] from, int[] to) {
        int x1 = from[0];
        int y1 = from[1];
        int x2 = to[0];
        int y2 = to[1];

        int dx = Math.abs(x1 - x2);
        int dy = Math.abs(y1 - y2);

        // 斜线走
        int time1 = Math.min(dx, dy);

        // 剩余距离直线走, 两个差值一定有一个是0
        int time2 = Math.abs(dx - time1) + Math.abs(dy - time1);
        return time1 + time2;
    }
}
// @lc code=end

