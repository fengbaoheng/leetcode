package algorithms;

/**
 * 1828.统计一个圆中点的数目
 */
public class Problem1828 {

    class Solution {
        public int[] countPoints(int[][] points, int[][] queries) {
            int[] results = new int[queries.length];

            for (int[] point : points) {
                for (int i = 0; i < queries.length; i++) {
                    int[] circle = queries[i];
                    if (isInCircle(point, circle)) {
                        results[i]++;
                    }
                }
            }

            return results;
        }

        /**
         * @param point  坐标点
         * @param circle 圆
         * @return 点是否在圆内部
         */
        private boolean isInCircle(int[] point, int[] circle) {
            int dx = point[0] - circle[0];
            int dy = point[1] - circle[1];
            int r = circle[2];

            return dx * dx + dy * dy <= r * r;
        }
    }


}