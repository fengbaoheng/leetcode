/*
 * @lc app=leetcode.cn id=999 lang=java
 *
 * [999] 车的可用捕获量
 */

// @lc code=start
class Solution {
    public int numRookCaptures(char[][] board) {
        final int size = 8;

        // 找到车的坐标
        int x = 0, y = 0;
        outerLoop:
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                char ch = board[r][c];
                if (ch == 'R') {
                    x = r;
                    y = c;
                    break outerLoop;
                }
            }
        }

        // 搜索方向
        int[][] moves = new int[][]{
                {0, 1}, {0, -1}, {1, 0}, {-1, 0}
        };

        int result = 0;

        // 向4周搜索,直到 1.撞墙 2.遇象 3.吃卒
        for (int[] move : moves) {
            int dx = move[0];
            int dy = move[1];

            int nextX = x;
            int nextY = y;

            while (true) {
                nextX += dx;
                nextY += dy;

                if (nextX < 0 || nextX >= size || nextY < 0 || nextY >= size) {
                    break;
                }

                char ch = board[nextX][nextY];
                if (ch != '.') {
                    result += ch == 'B' ? 0 : 1;
                    break;
                }
            }
        }

        return result;
    }
}
// @lc code=end

