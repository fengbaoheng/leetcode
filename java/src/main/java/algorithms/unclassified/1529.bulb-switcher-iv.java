/*
 * @lc app=leetcode.cn id=1529 lang=java
 *
 * [1529] 灯泡开关 IV
 */

// @lc code=start
class Solution {
    public int minFlips(String target) {
        int endState = 0;
        int count = 0;

        for (int i = 0; i < target.length(); i++) {
            int curState = target.charAt(i) - '0';

            // 无需翻转
            if (endState == curState) {
                continue;
            }

            // 翻转剩余的灯
            endState = (endState + 1) % 2;
            count++;
        }

        return count;
    }
}
// @lc code=end

