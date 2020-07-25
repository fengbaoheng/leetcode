/*
 * @lc app=leetcode.cn id=856 lang=java
 *
 * [856] 括号的分数
 */

// @lc code=start
import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int scoreOfParentheses(String S) {
        Deque<Integer> stack = new ArrayDeque<>(S.length());
        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.push(0);
            } else {
                int top = stack.pop();
                int score;
                if (top == 0) {
                    score = 1;
                } else {
                    score = 2 * top;
                    while (stack.peek() != 0) {
                        score += stack.pop();
                    }
                    stack.pop();
                }
                while (!stack.isEmpty() && stack.peek() != 0) {
                    score += stack.pop();
                }
                stack.push(score);
            }
        }

        return stack.peek();
    }
}
// @lc code=end

