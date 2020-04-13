/*
 * @lc app=leetcode.cn id=1395 lang=java
 *
 * [1395] 统计作战单位数
 */

// @lc code=start
class Solution {
    public int numTeams(int[] rating) {
        final int size = rating.length;

        // 记录在当前位置后方，有多少士兵评分高于或低于自己
        int[] bigger = new int[size];
        int[] smaller = new int[size];

        // 统计每个士兵与后续士兵的评分比较
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (rating[j] > rating[i]) {
                    bigger[i]++;
                } else if (rating[j] < rating[i]) {
                    smaller[i]++;
                }
            }
        }

        // 计算
        int result = 0;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (rating[j] > rating[i]) {
                    // 递增趋势
                    result += bigger[j];
                } else if (rating[j] < rating[i]) {
                    // 递减趋势
                    result += smaller[j];
                }
            }
        }
        return result;
    }
}
// @lc code=end
