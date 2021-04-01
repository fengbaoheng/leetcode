/*
 * @lc app=leetcode.cn id=1614 lang=java
 *
 * [1614] 括号的最大嵌套深度
 */

// @lc code=start
class Solution {
    public int maxDepth(String s) {
        int depth = 0;
        int maxDepth = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                depth++;
                maxDepth = Math.max(depth, maxDepth);
            } else if (c == ')') {
                depth--;
            }
        }

        return maxDepth;
    }
}
// @lc code=end

