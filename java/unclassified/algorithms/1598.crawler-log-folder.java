/*
 * @lc app=leetcode.cn id=1598 lang=java
 *
 * [1598] 文件夹操作日志搜集器
 */

// @lc code=start
class Solution {
    public int minOperations(String[] logs) {
        int depth = 0;

        for (String log : logs) {
            int move = getMove(log);
            if (move == -1) {
                // 非根目录需要回退一层
                if (depth > 0) {
                    depth--;
                }
            } else {
                depth += move;
            }
        }

        return depth;
    }

    private int getMove(String log) {
        if ("../".equals(log)) {
            return -1;
        } else if ("./".equals(log)) {
            return 0;
        } else {
            return 1;
        }
    }

}
// @lc code=end

