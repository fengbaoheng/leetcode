/*
 * @lc app=leetcode.cn id=844 lang=java
 *
 * [844] 比较含退格的字符串
 */

// @lc code=start

class Solution {
    // 栈, #出栈 其他字符入栈
    public boolean backspaceCompare(String S, String T) {
        return getString(S).equals(getString(T));
    }

    // 获取过滤后的字符串
    private String getString(String str) {
        StringBuilder stringBuilder = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (c == '#') {
                int length = stringBuilder.length();
                if (length > 0) {
                    stringBuilder.deleteCharAt(length - 1);
                }
            } else {
                stringBuilder.append(c);
            }
        }

        return stringBuilder.toString();
    }
}

// @lc code=end

