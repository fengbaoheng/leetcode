/*
 * @lc app=leetcode.cn id=1222 lang=java
 *
 * [1222] 可以攻击国王的皇后
 */

// @lc code=start
import java.util.*;

class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        final int rows = 8;
        final int cols = 8;

        // 棋盘
        boolean[][] board = new boolean[rows][cols];

        // 标记皇后在棋盘上的位置
        for (int[] queen : queens) {
            int r = queen[0];
            int c = queen[1];
            board[r][c] = true;
        }

        List<List<Integer>> results = new LinkedList<>();

        // 横竖斜的移动方向
        int[][] moves = new int[][]{
                {0, 1}, {0, -1}, // 水平
                {1, 0}, {-1, 0}, // 垂直
                {-1, -1}, {1, 1}, // 左斜
                {1, -1},{-1, 1} // 右斜
        };


        // 深度优先在各方向搜索
        for (int[] move : moves) {
            // 以国王位置为起始点
            int r = king[0];
            int c = king[1];

            // 一直沿着该方向搜索直到碰撞边界
            while (r >= 0 && r < rows && c >= 0 && c < cols) {
                // 遭遇皇后停止在该方向搜索
                if (board[r][c]) {
                    List<Integer> queen = new LinkedList<>();
                    queen.add(r);
                    queen.add(c);
                    results.add(queen);
                    break;
                }

                r += move[0];
                c += move[1];
            }
        }

        return results;
    }
}
// @lc code=end

