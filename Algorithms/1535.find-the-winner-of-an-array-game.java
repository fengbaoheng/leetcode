/*
 * @lc app=leetcode.cn id=1535 lang=java
 *
 * [1535] 找出数组游戏的赢家
 */

// @lc code=start
class Solution {
    public int getWinner(int[] arr, int k) {
        int len = arr.length;

        // 记录赢家和连胜数目
        int winner = arr[0];
        int winCount = 0;


        for (int i = 1; i < len; i++) {
            int num = arr[i];
            if (num < winner) {
                // 连胜则更新数据
                winCount++;
            } else {
                // 产生了新赢家，该赢家第一次胜利
                winner = num;
                winCount = 1;
            }

            if (winCount >= k) {
                return winner;
            }
        }

        // 遍历一遍后的winner是当前数组的最大值
        // 其一定是最后的赢家，因为之后的每次比较都是其胜出
        return winner;
    }
}
// @lc code=end

