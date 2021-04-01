/*
 * @lc app=leetcode.cn id=1541 lang=java
 *
 * [1541] 平衡括号字符串的最少插入次数
 */

// @lc code=start
class Solution {
    public int minInsertions(String s) {
        int value = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                value++;
            } else {
                value--;

                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    // "))"
                    i++;
                } else {
                    // 必须补充一个’)‘
                    count++;
                }

                // 不能为负数，即左括号必须在右括号之前
                if (value < 0) {
                    count += -value;
                    value = 0;
                }
            }
        }

        if (value > 0) {
            // 多余了左括号，每个左括号插入2个右括号
            count += value * 2;
        }

        return count;
    }
}
// @lc code=end

