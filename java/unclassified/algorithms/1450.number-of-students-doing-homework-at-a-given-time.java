/*
 * @lc app=leetcode.cn id=1450 lang=java
 *
 * [1450] 在既定时间做作业的学生人数
 */

// @lc code=start
class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count = 0;
        for (int i = 0; i < endTime.length; i++) {
            if (queryTime <= endTime[i]) {
                if (queryTime >= startTime[i]) {
                    count++;
                }
            }
        }
        return count;
    }
}
// @lc code=end

