/*
 * @lc app=leetcode.cn id=1047 lang=java
 *
 * [1047] 删除字符串中的所有相邻重复项
 */

class Solution {
    // 使用栈, 相同则出栈, 不同则入栈
    public String removeDuplicates(String S) {
        // 便于拼接字符串
        StringBuilder stack = new StringBuilder();
        for (char cur : S.toCharArray()) {
            // 上个字符
            int lastIndex = stack.length() - 1;
            char last = lastIndex == -1 ? ' ' : stack.charAt(lastIndex);

            // 入栈与出栈
            if (cur == last) {
                stack.deleteCharAt(lastIndex);
            } else {
                stack.append(cur);
            }
        }

        return stack.toString();
    }
}
