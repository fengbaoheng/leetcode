package algorithms;

import java.util.stream.IntStream;

/**
 * 1824.最少侧跳次数
 */
public class Problem1824 {
    static class Solution {
        private static final int MAX = 1000000;

        // 动态规划
        public int minSideJumps(int[] obstacles) {
            int[] pre = {Integer.MAX_VALUE, 1, 0, 1};
            int[] next = {Integer.MAX_VALUE, 1, 0, 1};

            for (int i = 1; i < obstacles.length; i++) {
                for (int from = 1; from <= 3; from++) {
                    for (int to = 1; to <= 3; to++) {
                        int jumps = 1;
                        if (from == to) {
                            // 直接向右移动
                            jumps = 0;
                        } else if (to == obstacles[i - 1] && from == obstacles[i]) {
                            // 必须转折两次的情况
                            jumps = 2;
                        }

                        next[to] = Math.min(next[to], pre[from] + jumps);
                    }
                }

                // 有障碍物
                next[obstacles[i]] = MAX;
                System.arraycopy(next, 1, pre, 1, 3);
            }
            return IntStream.of(pre).min().orElse(0);
        }
    }
}