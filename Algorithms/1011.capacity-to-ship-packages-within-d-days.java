/*
 * @lc app=leetcode.cn id=1011 lang=java
 *
 * [1011] 在 D 天内送达包裹的能力
 */

// @lc code=start
class Solution {
    public int shipWithinDays(int[] weights, int D) {
        // 能力上限：1天运输完
        // 能力下限：恰好D天运输完
        int max = 0, min = 0;
        for (int weight : weights) {
            max += weight;
            min = Math.max(min, weight);
        }

        min = Math.max(min, max / D);

        // 二分搜索
        int result = max;

        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (canTransfer(weights, D, mid)) {
                result = Math.min(result, mid);
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return result;
    }

    private boolean canTransfer(int[] weights, int maxDays, int ability) {
        int sum = 0;
        int days = 1;

        for (int weight : weights) {
            sum += weight;

            if (sum > ability) {
                days++;
                sum = weight;

                if (days > maxDays) {
                    return false;
                }
            }
        }

        return true;
    }
}
// @lc code=end

