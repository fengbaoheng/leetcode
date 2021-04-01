/*
 * @lc app=leetcode.cn id=1235 lang=java
 *
 * [1235] 规划兼职工作
 */

// @lc code=start
import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.TreeMap;

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;

        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(i, startTime, endTime, profit);
        }
        Arrays.sort(jobs, Comparator.comparingInt(job -> job.end));


        int maxProfit = 0;
        TreeMap<Integer, Integer> profitMap = new TreeMap<>();
        for (Job job : jobs) {
            // 动态规划
            
            // 计算之前利润
            int preProfit = Optional
                    .ofNullable(profitMap.floorKey(job.start))
                    .map(profitMap::get)
                    .orElse(0);
            int curProfit = preProfit + job.profit;
            
            maxProfit = Math.max(maxProfit, curProfit);
            profitMap.put(job.end, maxProfit);
        }

        return maxProfit;
    }

    // Job类型
    private static class Job {
        private final int start, end, profit;

        public Job(int i, int[] start, int[] end, int[] profit) {
            this.start = start[i];
            this.end = end[i];
            this.profit = profit[i];
        }
    }
}
// @lc code=end

