/*
 * @lc app=leetcode.cn id=1576 lang=java
 *
 * [1576] 替换所有的问号
 */

// @lc code=start
class Solution {
    public String modifyString(String s) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != '?') {
                builder.append(ch);
                continue;
            }

            char left = i > 0 ? builder.charAt(i - 1) : ' ';
            char right = i < s.length() - 1 ? s.charAt(i + 1) : ' ';

            // 遍历所有可能找到替换的字符
            for (int j = 0; j < 26; j++) {
                char replace = (char) ('a' + j);
                if (replace != left && replace != right) {
                    builder.append(replace);
                    break;
                }
            }
        }

        return builder.toString();
    }
}
// @lc code=end

