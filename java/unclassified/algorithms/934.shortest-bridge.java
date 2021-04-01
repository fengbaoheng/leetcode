/*
 * @lc app=leetcode.cn id=934 lang=java
 *
 * [934] 最短的桥
 */

// @lc code=start
import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    private static final int[][] MOVES = {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };

    public int shortestBridge(int[][] A) {
        int rows = A.length;
        int cols = A[0].length;

        // 防止重复搜索
        boolean[][] visited = new boolean[rows][cols];

        // 先找到第一座小岛
        Queue<int[]> island = new ArrayDeque<>();
        outer:
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (A[r][c] == 1) {
                    visited[r][c] = true;
                    island.add(new int[]{r, c});
                    break outer;
                }
            }
        }

        // 找到小岛的一圈边界
        Queue<int[]> border = new ArrayDeque<>();
        while (!island.isEmpty()) {
            int[] point = island.poll();
            for (int[] move : MOVES) {
                int r = point[0] + move[0];
                int c = point[1] + move[1];
                if (canMove(rows, cols, r, c) && !visited[r][c]) {
                    visited[r][c] = true;
                    (A[r][c] == 1 ? island : border).offer(new int[]{r, c});
                }
            }
        }


        int length = 1;

        // 广度优先搜索，逐步扩大边界，直到和另一座小岛接触
        while (!border.isEmpty()) {
            int size = border.size();
            // 所有边界向外扩展1个单位长度
            for (int i = 0; i < size; i++) {
                int[] point = border.poll();
                for (int[] move : MOVES) {
                    int r = point[0] + move[0];
                    int c = point[1] + move[1];
                    if (canMove(rows, cols, r, c) && !visited[r][c]) {
                        // 已经接触到了
                        if (A[r][c] == 1) {
                            return length;
                        } else {
                            visited[r][c] = true;
                            border.offer(new int[]{r, c});
                        }
                    }
                }
            }

            // 本轮没有接触到第二座岛
            length++;
        }

        return length;
    }

    private boolean canMove(int rows, int cols, int r, int c) {
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }
}
// @lc code=end

