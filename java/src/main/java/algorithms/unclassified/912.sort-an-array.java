/*
 * @lc app=leetcode.cn id=912 lang=java
 *
 * [912] 排序数组
 */

// @lc code=start
class Solution {
    public int[] sortArray(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int[] counts = new int[max - min + 1];
        int offset = -min;

        for (int num : nums) {
            counts[num + offset]++;
        }

        int[] sorted = new int[nums.length];
        int p = 0;
        for (int i = 0; i < counts.length; i++) {
            int count = counts[i];
            if (count == 0) {
                continue;
            }

            int num = i - offset;
            for (int c = 0; c < count; c++) {
                sorted[p] = num;
                p++;
            }
        }

        return sorted;
    }
}
// @lc code=end

