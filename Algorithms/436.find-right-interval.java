/*
 * @lc app=leetcode.cn id=436 lang=java
 *
 * [436] 寻找右区间
 */

// @lc code=start
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;

        // 构建区间对象
        Interval[] intervalArr = new Interval[n];
        for (int i = 0; i < intervals.length; i++) {
            intervalArr[i] = new Interval(i, intervals[i]);
        }


        // 按区间起始位置建立映射
        TreeMap<Integer, Interval> startMap = new TreeMap<>();
        for (Interval interval : intervalArr) {
            startMap.put(interval.start, interval);
        }

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int leftEnd = intervalArr[i].end;

            // 依次寻找右区间
            Interval rightInterval = startMap.get(leftEnd);
            if (rightInterval == null) {
                rightInterval = Optional
                        .ofNullable(startMap.higherEntry(leftEnd))
                        .map(Map.Entry::getValue)
                        .orElse(null);
            }

            result[i] = rightInterval == null ? -1 : rightInterval.index;
        }

        return result;
    }

    // 封装区间对象
    private static class Interval {
        public final int index;
        public final int start;
        public final int end;

        public Interval(int index, int[] arr) {
            this.index = index;
            this.start = arr[0];
            this.end = arr[1];
        }
    }
}
// @lc code=end

