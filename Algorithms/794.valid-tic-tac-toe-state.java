/*
 * @lc app=leetcode.cn id=794 lang=java
 *
 * [794] 有效的井字游戏
 */

// @lc code=start
class Solution {
    public boolean validTicTacToe(String[] board) {
        return new Board().check(board);
    }
}


class Board {
    // 棋盘状态
    char[][] s = new char[3][3];

    // 分别记录X-O棋子的数量
    int xCount = 0;
    int oCount = 0;

    public boolean check(String[] board) {
        // 读入数据
        init(board);

        // 校验差值
        int diffXO = xCount - oCount;
        if (!(diffXO <= 1 && diffXO >= 0)) {
            return false;
        }

        // 下个出手的玩家绝对不能已经获胜
        char nextPlayer = xCount == oCount ? 'X' : 'O';
        if (isWin(nextPlayer)) {
            return false;
        }

        return true;
    }

    private void init(String[] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char ch = board[i].charAt(j);
                s[i][j] = ch;

                if (ch == 'X') {
                    xCount++;
                } else if (ch == 'O') {
                    oCount++;
                }
            }
        }
    }

    private boolean isWin(char piece) {
        return isRowWin(piece) || isColWin(piece) || isSlashWin(piece);
    }


    private boolean isRowWin(char piece) {
        for (int i = 0; i < 3; i++) {
            if (s[i][0] == piece && s[i][1] == piece && s[i][2] == piece) {
                return true;
            }
        }
        return false;
    }

    private boolean isColWin(char piece) {
        for (int i = 0; i < 3; i++) {
            if (s[0][i] == piece && s[1][i] == piece && s[2][i] == piece) {
                return true;
            }
        }
        return false;
    }

    private boolean isSlashWin(char piece) {
        if (s[1][1] != piece) {
            return false;
        }

        return (s[0][0] == piece && s[2][2] == piece) || (s[0][2] == piece && s[2][0] == piece);
    }
}
// @lc code=end

