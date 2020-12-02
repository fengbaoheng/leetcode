/*
 * @lc app=leetcode.cn id=1620 lang=java
 *
 * [1620] 网络信号最好的坐标
 */

// @lc code=start
class Solution {
    private static final int X = 50, Y = 50;

    public int[] bestCoordinate(int[][] towers, int radius) {
        int[][] map = new int[X + 1][Y + 1];
        
        // 半径平方
        int squareRadius = radius * radius;

        // 依次计算每个塔的信号覆盖
        for (int[] tower : towers) {
            int x = tower[0];
            int y = tower[1];
            int q = tower[2];

            // 该塔可能的影响范围
            int left = Math.max(0, x - radius);
            int right = Math.min(X, x + radius);
            int up = Math.max(0, y - radius);
            int down = Math.min(Y, y + radius);
            
            // 范围内每个坐标点计算信号值
            for (int i = left; i <= right; i++) {
                for (int j = up; j <= down; j++) {
                    // 先通过距离的平方和半径的平方比较，排除不在半径范围内的点
                    int squareDistance = (i - x) * (i - x) + (j - y) * (j - y);
                    if (squareDistance > squareRadius) {
                        continue;
                    }

                    // 叠加信号强度
                    map[i][j] += (int) (q / (1 + Math.sqrt(squareDistance)));
                }
            }
        }


        int maxQ = 0;
        int[] pos = {0, 0};

        // 遍历找最大值
        for (int i = 0; i <= X; i++) {
            for (int j = 0; j <= Y; j++) {
                int q = map[i][j];
                if (q > maxQ) {
                    maxQ = q;
                    pos[0] = i;
                    pos[1] = j;
                }
            }
        }

        return pos;
    }
}
// @lc code=end

