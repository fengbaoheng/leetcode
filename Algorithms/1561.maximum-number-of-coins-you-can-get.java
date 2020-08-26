/*
 * @lc app=leetcode.cn id=1561 lang=java
 *
 * [1561] 你可以获得的最大硬币数目
 */

// @lc code=start
import java.util.Arrays;


class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);

        // 贪心
        int sum = 0, index = piles.length;
        for (int i = 0; i < piles.length / 3; i++) {
            index -= 2;
            sum += piles[index];
        }

        return sum;
    }
}
// @lc code=end

