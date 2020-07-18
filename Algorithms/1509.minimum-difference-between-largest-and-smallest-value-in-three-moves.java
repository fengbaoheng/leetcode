/*
 * @lc app=leetcode.cn id=1509 lang=java
 *
 * [1509] 三次操作后最大值与最小值的最小差
 */

// @lc code=start
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    public int minDifference(int[] nums) {
        Arrays.sort(nums);
        Deque<Integer> deque = new ArrayDeque<>(nums.length);
        for (int num : nums) {
            deque.offerLast(num);
        }

        return minDiff(deque, 3);
    }

    private int minDiff(Deque<Integer> deque, int count) {
        if (deque.isEmpty()) {
            return 0;
        }

        if (count == 0) {
            return deque.peekLast() - deque.peekFirst();
        }

        int max = deque.pollLast();
        int r1 = minDiff(deque, count - 1);
        deque.offerLast(max);

        int min = deque.pollFirst();
        int r2 = minDiff(deque, count - 1);
        deque.offerFirst(min);

        return Math.min(r1, r2);
    }
}
// @lc code=end

