import java.util.*;

/*
 * @lc app=leetcode.cn id=740 lang=java
 *
 * [740] 删除与获得点数
 */

// @lc code=start
class Solution {
    // 动态规划
    // 选择/不选择 当前点数
    public int deleteAndEarn(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, num, Integer::sum);
        }

        List<Integer> keys = new ArrayList<>(map.keySet());

        int size = keys.size();
        int[] dp = new int[size];

        dp[0] = map.get(keys.get(0));

        for (int i = 1; i < size; i++) {
            int key = keys.get(i);
            int value = map.get(key);

            int preKey = keys.get(i - 1);
            if (key > preKey + 1) {
                // 选择当前数字不会删除前一个数字
                // 即直接叠加
                dp[i] = dp[i - 1] + value;
            } else {
                // 选择当前数字会删除前一个数字
                // 比较两种情况择优
                int prepreValue = i >= 2 ? dp[i - 2] : 0;
                dp[i] = Math.max(dp[i - 1], value + prepreValue);
            }

        }

        return dp[size - 1];
    }
}
// @lc code=end
