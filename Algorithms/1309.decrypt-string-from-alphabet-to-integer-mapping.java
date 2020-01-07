/*
 * @lc app=leetcode.cn id=1309 lang=java
 *
 * [1309] 解码字母到整数映射
 */

// @lc code=start
import java.util.*;

class Solution {
    public String freqAlphabets(String s) {
        // 依次转换映射压栈
        Deque<Character> stack = new LinkedList<>();

        // 从后向前映射
        int len = s.length();
        for (int i = len - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            char mapped;
            if (ch == '#') {
                mapped = (char) ('j' + (s.charAt(i - 2) - '1') * 10 + (s.charAt(i - 1) - '0'));
                i -= 2;
            } else {
                mapped = (char) ('a' + ch - '1');
            }
            stack.push(mapped);
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.poll());
        }

        return stringBuilder.toString();
    }
}
// @lc code=end

