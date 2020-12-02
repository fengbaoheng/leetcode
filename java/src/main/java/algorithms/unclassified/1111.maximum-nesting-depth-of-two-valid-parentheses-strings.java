/*
 * @lc app=leetcode.cn id=1111 lang=java
 *
 * [1111] 有效括号的嵌套深度
 */

// @lc code=start
import java.util.*;

class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        final int N = seq.length();
        int[] result = new int[N];
        int group = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            char c = seq.charAt(i);

            if (c == '(') {
                if (!stack.isEmpty()) {
                    group = (stack.peek() + 1) % 2;
                }
                stack.push(group);
                result[i] = group;
            } else {
                result[i] = stack.pop();
            }
        }

        return result;
    }
}
// @lc code=end

