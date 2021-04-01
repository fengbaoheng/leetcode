/*
 * @lc app=leetcode.cn id=1375 lang=java
 *
 * [1375] 灯泡开关 III
 */

// @lc code=start
import java.util.TreeSet;

class Solution {
    public int numTimesAllBlue(int[] light) {
        int n = light.length;

        TreeSet<Integer> off = new TreeSet<>();
        TreeSet<Integer> on = new TreeSet<>();

        for (int i = 1; i <= n; i++) {
            off.add(i);
        }

        int count = 0;
        for (int id : light) {
            off.remove(id);
            on.add(id);

            int maxOnId = on.last();
            int minOffId = off.isEmpty() ? Integer.MAX_VALUE : off.first();

            if (minOffId > maxOnId) {
                count++;
            }
        }

        return count;
    }
}
// @lc code=end

