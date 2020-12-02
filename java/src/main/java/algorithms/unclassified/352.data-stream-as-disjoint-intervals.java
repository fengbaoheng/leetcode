/*
 * @lc app=leetcode.cn id=352 lang=java
 *
 * [352] 将数据流变为多个不相交区间
 */

// @lc code=start
import java.util.*;

class SummaryRanges {
    TreeMap<Integer, Integer> map = new TreeMap<>();

    /**
     * Initialize your data structure here.
     */
    public SummaryRanges() {

    }

    public void addNum(int val) {
        // 无需扩展
        if (map.containsKey(val) || map.containsValue(val)) {
            return;
        }

        // 默认区间
        int start = val, end = val;

        // 尝试向前扩展
        Map.Entry<Integer, Integer> floor = map.floorEntry(start);
        if (floor != null && floor.getValue() >= start - 1) {
            start = floor.getKey();
            end = Math.max(end, floor.getValue());
        }


        // 尝试向后扩展
        Map.Entry<Integer, Integer> ceiling = map.ceilingEntry(end);
        if (ceiling != null && ceiling.getKey() == val + 1) {
            end = ceiling.getValue();
            map.remove(ceiling.getKey());
        }

        map.put(start, end);

    }

    public int[][] getIntervals() {
        int N = map.size();
        int[][] intervals = new int[N][2];

        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            intervals[i][0] = entry.getKey();
            intervals[i][1] = entry.getValue();
            i++;
        }
        return intervals;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */
// @lc code=end

