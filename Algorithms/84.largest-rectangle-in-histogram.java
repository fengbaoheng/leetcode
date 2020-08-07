/*
 * @lc app=leetcode.cn id=84 lang=java
 *
 * [84] 柱状图中最大的矩形
 */

// @lc code=start
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;


class Solution {
    // 单调栈
    public int largestRectangleArea(int[] heights) {
        final int N = heights.length;

        int[] weights = new int[N];
        Arrays.fill(weights, 1);

        Deque<Integer> stack = new ArrayDeque<>();

        int maxArea = Integer.MIN_VALUE;

        // 遍历一遍维持递增单调
        for (int i = 0; i < N; i++) {
            int height = heights[i];
            int pre = 0;

            while (!stack.isEmpty() && height <= heights[stack.peek()]) {
                int j = stack.pop();
                pre += weights[j];
                weights[j] += i - 1 - j;
                maxArea = Math.max(maxArea, heights[j] * weights[j]);
            }

            weights[i] += pre;

            stack.push(i);
        }

        // 更新栈中剩余
        while (!stack.isEmpty()) {
            int i = stack.pop();
            weights[i] += N - 1 - i;
            maxArea = Math.max(maxArea, heights[i] * weights[i]);
        }


        return maxArea;
    }
}
// @lc code=end

