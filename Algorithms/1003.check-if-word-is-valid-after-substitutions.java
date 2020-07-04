/*
 * @lc app=leetcode.cn id=1003 lang=java
 *
 * [1003] 检查替换后的词是否有效
 */

// @lc code=start
import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public boolean isValid(String S) {
        Deque<Character> stack = new ArrayDeque<>(S.length());

        for (char c : S.toCharArray()) {
            switch (c) {
                case 'a':
                    stack.push(c);
                    break;
                case 'b':
                    if (stack.isEmpty() || stack.peek() != 'a') {
                        return false;
                    }
                    stack.push(c);
                    break;
                case 'c':
                    if (stack.size() < 2 || stack.peek() != 'b') {
                        return false;
                    }
                    stack.pop();
                    stack.pop();
                    break;
            }
        }

        return stack.isEmpty();
    }
}
// @lc code=end

