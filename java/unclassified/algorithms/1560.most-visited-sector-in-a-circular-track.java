/*
 * @lc app=leetcode.cn id=1560 lang=java
 *
 * [1560] 圆形赛道上经过次数最多的扇区
 */

// @lc code=start
import java.util.LinkedList;
import java.util.List;


class Solution {
    public List<Integer> mostVisited(int n, int[] rounds) {
        int circle = 0;
        int start = rounds[0];
        int end = rounds[0];
        for (int i = 1; i < rounds.length; i++) {
            if (rounds[i] < end) {
                circle++;
            }
            end = rounds[i];
        }

        List<Integer> result = new LinkedList<>();

        if (circle > 0 && end < start) {
            for (int i = 1; i <= end; i++) {
                result.add(i);
            }

            for (int i = start; i <= n; i++) {
                result.add(i);
            }
        } else {
            for (int i = start; i <= end; i++) {
                result.add(i);
            }
        }

        return result;
    }
}
// @lc code=end

