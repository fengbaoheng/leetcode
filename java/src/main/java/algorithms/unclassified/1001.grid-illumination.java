/*
 * @lc app=leetcode.cn id=1001 lang=java
 *
 * [1001] 网格照明
 */

// @lc code=start
import java.util.*;

class Solution {
    public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
        Grid grid = new Grid(N, lamps);

        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0];
            int y = queries[i][1];

            result[i] = grid.isBright(x, y) ? 1 : 0;
            grid.close(x, y);
        }

        return result;
    }


}


class Grid {
    private final int N;

    // 相邻的9个单元格
    private final int[][] neighbors = {{0, 0}, {0, 1}, {0, -1}, {1, 0}, {1, 1}, {1, -1}, {-1, 0}, {-1, -1}, {-1, 1}};


    // 记录开着的灯的数量
    private final Set<Integer> lamps;
    private final Map<Integer, Integer> horizontal = new HashMap<>();
    private final Map<Integer, Integer> vertical = new HashMap<>();
    private final Map<Integer, Integer> left = new HashMap<>();
    private final Map<Integer, Integer> right = new HashMap<>();

    public Grid(int n, int[][] lamps) {
        N = n;

        this.lamps = new HashSet<>(lamps.length);
        for (int[] lamp : lamps) {
            int x = lamp[0];
            int y = lamp[1];

            this.lamps.add(x * N + y);
            horizontal.merge(x, 1, Integer::sum);
            vertical.merge(y, 1, Integer::sum);
            left.merge(x - y, 1, Integer::sum);
            right.merge(x + y, 1, Integer::sum);
        }
    }

    public boolean isBright(int x, int y) {
        return lamps.contains(x * N + y)
                || horizontal.getOrDefault(x, 0) > 0
                || vertical.getOrDefault(y, 0) > 0
                || left.getOrDefault(x - y, 0) > 0
                || right.getOrDefault(x + y, 0) > 0;
    }

    // 关闭周围9个单元格的灯
    public void close(int x, int y) {
        for (int[] neighbor : neighbors) {
            closeOne(x + neighbor[0], y + neighbor[1]);
        }
    }

    // 关闭1个灯
    private void closeOne(int x, int y) {
        if (lamps.remove(x * N + y)) {
            horizontal.merge(x, -1, Integer::sum);
            vertical.merge(y, -1, Integer::sum);
            left.merge(x - y, -1, Integer::sum);
            right.merge(x + y, -1, Integer::sum);
        }
    }
}
// @lc code=end

