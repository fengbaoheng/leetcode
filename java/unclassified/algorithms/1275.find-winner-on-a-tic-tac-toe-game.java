/*
 * @lc app=leetcode.cn id=1275 lang=java
 *
 * [1275] 找出井字棋的获胜者
 */

// @lc code=start
import java.util.*;

class Solution {
    int[][] board = new int[3][3];

    public String tictactoe(int[][] moves) {
        int step = 0;
        int player = 1;
        for (int[] move : moves) {
            int x = move[0];
            int y = move[1];

            board[x][y] = player;
            boolean win = judge(x, y);

            if (win) {
                return player == 1 ? "A" : "B";
            }

            player = player % 2 + 1;
            step++;
        }

        return step == 9 ? "Draw" : "Pending";
    }


    private boolean judge(int x, int y) {
        List<int[]> group = new LinkedList<>();

        // 水平
        int[] hValue = new int[3];
        for (int i = 0; i < 3; i++) {
            hValue[i] = board[x][i];
        }
        group.add(hValue);

        // 竖直
        int[] vValue = new int[3];
        for (int i = 0; i < 3; i++) {
            vValue[i] = board[i][y];
        }
        group.add(vValue);

        // 左斜线
        if (x == y) {
            int[] pValue = new int[3];
            for (int i = 0; i < 3; i++) {
                pValue[i] = board[i][i];
            }
            group.add(pValue);
        }

        // 右斜线
        if (x + y == 2) {
            int[] pValue = new int[3];
            for (int i = 0; i < 3; i++) {
                pValue[i] = board[i][2 - i];
            }
            group.add(pValue);
        }


        int value = board[x][y];
        for (int[] g : group) {
            if (g[0] == value && g[1] == value && g[2] == value) {
                return true;
            }
        }

        return false;
    }
}
// @lc code=end

