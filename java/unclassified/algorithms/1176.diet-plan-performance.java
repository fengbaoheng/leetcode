/*
 * @lc app=leetcode.cn id=1176 lang=java
 *
 * [1176] 健身计划评估
 */
class Solution {
    // 滑动窗口一次计算T的值
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        final int length = calories.length;

        int score = 0;
        int T = 0;
        for (int i = 0; i < k; i++) {
            T += calories[i];
        }

        if (T < lower) {
            score -= 1;
        } else if (T > upper) {
            score += 1;
        }

        for (int i = 1; i <= length - k; i++) {
            // 移除最左 添加最右
            T -= calories[i - 1];
            T += calories[i + k - 1];

            if (T < lower) {
                score -= 1;
            } else if (T > upper) {
                score += 1;
            }
        }

        return score;
    }
}