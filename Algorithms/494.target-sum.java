/*
 * @lc app=leetcode.cn id=494 lang=java
 *
 * [494] 目标和
 */

// @lc code=start
import java.util.*;

class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        Map<Integer, Integer> count = new HashMap<>();

        count.merge(nums[0], 1, Integer::sum);
        count.merge(-nums[0], 1, Integer::sum);

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            Map<Integer, Integer> newCount = new HashMap<>();

            count.forEach((sum, c) -> {
                newCount.merge(sum + num, c, Integer::sum);
                newCount.merge(sum - num, c, Integer::sum);
            });

            count = newCount;
        }

        return Optional.ofNullable(count.get(S)).orElse(0);
    }
}
// @lc code=end

