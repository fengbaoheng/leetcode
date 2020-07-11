/*
 * @lc app=leetcode.cn id=812 lang=java
 *
 * [812] 最大三角形面积
 */

// @lc code=start
class Solution {
    public double largestTriangleArea(int[][] points) {
        int n = points.length;
        int[] p1, p2, p3;
        double maxArea = 0;

        // 遍历所有组合求最大面积
        for (int i = 0; i < n - 2; i++) {
            p1 = points[i];
            for (int j = i + 1; j < n - 1; j++) {
                p2 = points[j];
                for (int k = j + 1; k < n; k++) {
                    p3 = points[k];
                    maxArea = Math.max(maxArea, getArea(p1, p2, p3));
                }
            }
        }
        return maxArea;
    }

    // 海伦公式求面积
    private double getArea(int[] p1, int[] p2, int[] p3) {
        double a = getDistance(p1, p2);
        double b = getDistance(p1, p3);
        double c = getDistance(p2, p3);

        double p = (a + b + c) / 2;
        return Math.sqrt(Math.abs(p * (p - a) * (p - b) * (p - c)));
    }

    // 计算两点间的距离
    private double getDistance(int[] p1, int[] p2) {
        int dx = p1[0] - p2[0];
        int dy = p1[1] - p2[1];
        return Math.sqrt(dx * dx + dy * dy);
    }
}
// @lc code=end

