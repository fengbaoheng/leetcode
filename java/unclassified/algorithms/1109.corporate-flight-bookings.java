/*
 * @lc app=leetcode.cn id=1109 lang=java
 *
 * [1109] 航班预订统计
 */
class Solution {
    //理解为公交车模型
    // k个人在i上车,在j+1下车
    // 索引从1开始, 即: i-1上车, j下车
    // 统计每个站公交车上的人数
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] result = new int[n];
        for (int[] booking : bookings) {
            int i = booking[0];
            int j = booking[1];
            int k = booking[2];

            // 编号:1 ~ n, 索引:0 ~ n-1
            result[i - 1] += k;

            if (j < n) {
                result[j] -= k;
            }
        }

        // 当前站的人数 = 前一站人数 + 本站变化人数
        for (int i = 1; i < n; i++) {
            result[i] += result[i - 1];
        }

        return result;
    }
}

