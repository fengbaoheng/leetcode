/*
 * @lc app=leetcode.cn id=532 lang=java
 *
 * [532] 数组中的K-diff数对
 */

// @lc code=start
import java.util.*;

class Solution {
    public int findPairs(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }

        if (k == 0) {
            return (int) map.values().stream().filter(value -> value >= 2).count();
        } else {
            return (int) map.keySet().stream().filter(key -> map.containsKey(key + k)).count();
        }
    }
}
// @lc code=end

