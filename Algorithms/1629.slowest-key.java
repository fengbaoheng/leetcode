/*
 * @lc app=leetcode.cn id=1629 lang=java
 *
 * [1629] 按键持续时间最长的键
 */

// @lc code=start
class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char maxCh = 'a';
        long maxTime = 0;

        for (int i = 0; i < releaseTimes.length; i++) {
            char ch = keysPressed.charAt(i);
            int time = i > 0 ? (releaseTimes[i] - releaseTimes[i - 1]) : releaseTimes[i];

            long compare = time == maxTime ? ch - maxCh : time - maxTime;
            if (compare > 0) {
                maxTime = time;
                maxCh = ch;
            }
        }

        return maxCh;
    }
}
// @lc code=end

