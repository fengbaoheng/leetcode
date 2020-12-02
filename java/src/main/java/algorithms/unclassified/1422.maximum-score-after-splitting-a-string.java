/*
 * @lc app=leetcode.cn id=1422 lang=java
 *
 * [1422] 分割字符串的最大得分
 */

// @lc code=start
class Solution {
    public int maxScore(String s) {
        int rightOne = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                rightOne++;
            }
        }

        int leftZero = 0;
        int result = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                leftZero++;
            } else if (s.charAt(i) == '1') {
                rightOne--;
            }

            result = Math.max(result, leftZero + rightOne);
        }

        return result;
    }
}
// @lc code=end

