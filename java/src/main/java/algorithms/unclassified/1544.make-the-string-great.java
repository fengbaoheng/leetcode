/*
 * @lc app=leetcode.cn id=1544 lang=java
 *
 * [1544] 整理字符串
 */

// @lc code=start
import java.util.ArrayDeque;
import java.util.Deque;


class Solution {
    public String makeGood(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (deque.size() > 0 && isUpperAndLower(deque.peekLast(), c)) {
                deque.pollLast();
            } else {
                deque.offerLast(c);
            }
        }

        // 栈中剩余字符拼接字符串
        StringBuilder builder = new StringBuilder();
        while (!deque.isEmpty()) {
            builder.append(deque.pollFirst());
        }

        return builder.toString();
    }

    // 判断两个字符是否正好是1大写1小写
    private boolean isUpperAndLower(char a, char b) {
        return (a - 'a' == b - 'A') || (a - 'A' == b - 'a');
    }
}
// @lc code=end

