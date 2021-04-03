package algorithms;

/**
 * 1779.找到最近的有相同 X 或 Y 坐标的点
 */
public class Problem1779 {
    static class Solution {
        public int nearestValidPoint(int x, int y, int[][] points) {
            int min = Integer.MAX_VALUE;
            int index = -1;

            for (int i = 0; i < points.length; i++) {
                int[] point = points[i];
                int px = point[0];
                int py = point[1];

                if (px == x && py == y) {
                    return i;
                }

                if (px == x) {
                    int dy = Math.abs(py - y);
                    if (dy < min) {
                        min = dy;
                        index = i;
                    }
                } else if (py == y) {
                    int dx = Math.abs(px - x);
                    if (dx < min) {
                        min = dx;
                        index = i;
                    }
                }
            }

            return index;
        }
    }
}