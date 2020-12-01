/*
 * @lc app=leetcode.cn id=1672 lang=java
 *
 * [1672] 最富有客户的资产总量
 */

// @lc code=start
import java.util.Arrays;

class Solution {
    public int maximumWealth(int[][] accounts) {
        return Arrays.stream(accounts).mapToInt(row -> Arrays.stream(row).sum()).max().orElse(0);
    }
}
// @lc code=end

