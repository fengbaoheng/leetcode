/*
 * @lc app=leetcode.cn id=1438 lang=java
 *
 * [1438] 绝对差不超过限制的最长连续子数组
 */

// @lc code=start
import java.util.*;


class Solution {
    public int longestSubarray(int[] nums, int limit) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        int left = 0;
        int maxLength = 0;
        for (int right = 0; right < nums.length; right++) {
            int num = nums[right];

            minHeap.offer(num);
            maxHeap.offer(num);

            while (left <= right) {
                int min = minHeap.element();
                int max = maxHeap.element();
                if (Math.abs(max - min) > limit) {
                    minHeap.remove(nums[left]);
                    maxHeap.remove(nums[left]);
                } else {
                    break;
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
// @lc code=end

