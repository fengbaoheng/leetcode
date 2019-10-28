/*
 * @lc app=leetcode.cn id=1232 lang=java
 *
 * [1232] 缀点成线
 */

// @lc code=start
class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int[] param = getParam(coordinates[0], coordinates[1]);

        for (int i = 2; i < coordinates.length; i++) {
            int[] p = getParam(coordinates[i - 1], coordinates[i]);
            if (!isSameLine(param, p)) {
                return false;
            }
        }

        return true;
    }

    // 获取直线方程的参数
    private int[] getParam(int[] p1, int[] p2) {
        int x1 = p1[0], y1 = p1[1], x2 = p2[0], y2 = p2[1];

        return new int[]{
                y2 - y1,
                x1 - x2,
                x2 * y1 - x1 * y2
        };
    }

    // 通过参数判定是否为同一直线
    private boolean isSameLine(int[] p1, int[] p2) {
        int a1 = p1[0], b1 = p1[1], c1 = p1[2];
        int a2 = p2[0], b2 = p2[1], c2 = p2[2];

        return (a1 * b2 == a2 * b1) && (b1 * c2 == b2 * c1);
    }
}
// @lc code=end

