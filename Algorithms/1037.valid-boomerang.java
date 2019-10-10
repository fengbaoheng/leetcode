/*
 * @lc app=leetcode.cn id=1037 lang=java
 *
 * [1037] 有效的回旋镖
 */

// @lc code=start
class Solution {
    public boolean isBoomerang(int[][] points) {
        Point p1 = new Point(points[0]);
        Point p2 = new Point(points[1]);
        Point p3 = new Point(points[2]);

        // 含有相同的点或三点共线
        return !hasSamePoint(p1, p2, p3) && !isSameLine(p1, p2, p3);
    }

    // 是否有相同的点
    private boolean hasSamePoint(Point p1, Point p2, Point p3) {
        return p1.isSame(p2) || p1.isSame(p3) || p2.isSame(p3);
    }

    // 向量是否共线
    private boolean isSameLine(Point p1, Point p2, Point p3) {
        Point v12 = p1.getVector(p2);
        Point v13 = p1.getVector(p3);

        return v12.x * v13.y == v12.y * v13.x;
    }
}

class Point {
    final int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Point(int[] p) {
        this.x = p[0];
        this.y = p[1];
    }

    boolean isSame(Point p) {
        return p.x == x && p.y == y;
    }

    Point getVector(Point p) {
        return new Point(p.x - x, p.y - y);
    }
}
// @lc code=end

