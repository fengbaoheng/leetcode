/*
 * @lc app=leetcode.cn id=1510 lang=java
 *
 * [1510] 石子游戏 IV
 */

// @lc code=start
class Solution {
    private static final int N = 100000;
    private static final boolean[] win = new boolean[N + 1];

    static {
        initWin();
    }

    private static void initWin() {
        for (int i = 1; i <= N; i++) {
            win[i] = isWinner(i);
        }
    }

    private static boolean isWinner(int n) {
        int sqrt = (int) Math.sqrt(n);

        // 逐个可能的数字尝试
        for (int i = sqrt; i > 0; i--) {
            // Alice拿走i*i个石子后，bob剩余n-i*i个石子
            int bob = n - i * i;

            // 如果bob对于剩余的石子是必输的情况
            // 则Alice必赢
            if (!win[bob]) {
                return true;
            }
        }

        // 所有尝试都无法赢
        return false;
    }

    public boolean winnerSquareGame(int n) {
        return win[n];
    }
}
// @lc code=end

