import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=57 lang=java
 *
 * [57] 插入区间
 */

// @lc code=start
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> front = new LinkedList<>();
        List<int[]> background = new LinkedList<>();

        int p = 0, q = intervals.length - 1;

        // 搜索区间前侧
        while (p <= q && intervals[p][1] < newInterval[0]) {
            front.add(intervals[p]);
            p++;
        }

        // 特殊情况: 插在所有区间末尾
        if (p == intervals.length) {
            front.add(newInterval);
            return front.toArray(new int[][] {});
        }

        // 搜索区间后侧
        while (p <= q && intervals[q][0] > newInterval[1]) {
            background.add(0, intervals[q]);
            q--;
        }

        // 特殊情况: 插在所有区间头部
        if (q == -1) {
            background.add(0, newInterval);
            return background.toArray(new int[][] {});
        }

        // 合并区间
        for (int i = p; i <= q; i++) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
        }
        front.add(newInterval);
        front.addAll(background);

        return front.toArray(new int[][] {});
    }
}
// @lc code=end
