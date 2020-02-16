/*
 * @lc app=leetcode.cn id=729 lang=java
 *
 * [729] 我的日程安排表 I
 */

// @lc code=start
import java.util.*;

class MyCalendar {
    private TreeMap<Integer, Integer> treeMap;

    public MyCalendar() {
        treeMap = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer preStart = treeMap.floorKey(start);
        Integer nextStart = treeMap.ceilingKey(start);

        boolean canStart = preStart == null || treeMap.get(preStart) <= start;
        boolean canEnd = nextStart == null || end <= nextStart;

        if (canStart && canEnd) {
            treeMap.put(start, end);
            return true;
        } else {
            return false;
        }
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
// @lc code=end

