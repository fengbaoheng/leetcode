/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 */

// @lc code=start
import java.util.*;


class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;

        Set<Integer> set = new HashSet<>(n);
        for (int num : nums) {
            set.add(num);
        }

        int maxCount = 0;
        for (int num : nums) {
            if (!set.contains(num)) {
                continue;
            }

            int min = num;
            int max = num;

            while (set.contains(min - 1)) {
                set.remove(min - 1);
                min--;
            }

            while (set.contains(max + 1)) {
                set.remove(max + 1);
                max++;
            }

            maxCount = Math.max(maxCount, max - min + 1);
        }

        return maxCount;
    }
}
// @lc code=end

