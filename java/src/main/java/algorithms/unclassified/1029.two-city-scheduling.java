/*
 * @lc app=leetcode.cn id=1029 lang=java
 *
 * [1029] 两地调度
 */

// @lc code=start
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int peopleCount = costs.length;

        // 按照去A地与去B地的差额排序
        // 优先让差额大的人去A地
        Arrays.sort(costs, Comparator.comparing((int[] cost) -> cost[1] - cost[0]).reversed());

        int sum = 0;
        for (int i = 0; i < peopleCount / 2; i++) {
            sum += costs[i][0];
        }

        for (int i = peopleCount / 2; i < peopleCount; i++) {
            sum += costs[i][1];
        }

        return sum;
    }
}
// @lc code=end

