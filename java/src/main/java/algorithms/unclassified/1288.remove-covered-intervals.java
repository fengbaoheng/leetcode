import java.util.*;

/*
 * @lc app=leetcode.cn id=1288 lang=java
 *
 * [1288] 删除被覆盖区间
 */

// @lc code=start
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Deque<Section> stack = new LinkedList<>();

        Arrays.stream(intervals).map(Section::new).sorted()
                .forEach(cur -> {
                    Section pre = stack.peek();
                    if (pre == null || !pre.isCover(cur)) {
                        stack.push(cur);
                    }
                });

        return stack.size();
    }
}

class Section implements Comparable<Section> {

    private final int start;
    private final int end;

    public Section(int[] interval) {
        this.start = interval[0];
        this.end = interval[1];
    }

    public boolean isCover(Section section) {
        return section.start >= this.start && section.end <= this.end;
    }

    @Override
    public int compareTo(Section o) {
        // start 由小到大排
        int compareStart = this.start - o.start;
        // end 由大到小排
        int compareEnd = o.end - this.end;
        return compareStart != 0 ? compareStart : compareEnd;
    }
}
// @lc code=end
