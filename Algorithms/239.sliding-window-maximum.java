/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */

// @lc code=start
import java.util.*;


class Solution {
    Deque<Integer> deque;
    int k;
    int[] nums;

    public int[] maxSlidingWindow(int[] nums, int k) {
        this.deque = new ArrayDeque<>(k);
        this.k = k;
        this.nums = nums;
        for (int i = 0; i < k - 1; i++) {
            offer(i);
        }

        int n = nums.length;
        int[] result = new int[n - k + 1];

        for (int i = k - 1; i < n; i++) {
            int j = offer(i);
            result[i - k + 1] = nums[j];
        }

        return result;
    }

    private int offer(int i) {
        if (deque.isEmpty()) {
            deque.offerLast(i);
            return i;
        }

        if (deque.peekFirst() <= i - k) {
            deque.pollFirst();
        }

        while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
            deque.pollLast();
        }

        deque.offerLast(i);
        return deque.peekFirst();
    }
}
// @lc code=end

