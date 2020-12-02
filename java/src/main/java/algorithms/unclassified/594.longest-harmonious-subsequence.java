/*
 * @lc app=leetcode.cn id=594 lang=java
 *
 * [594] 最长和谐子序列
 */

// @lc code=start

import java.util.*;

class Solution {
    public int findLHS(int[] nums) {
        // 排序用以比较相邻的数字
        Arrays.sort(nums);

        int lastKey = Integer.MIN_VALUE;
        int lastValue = 0;
        int curKey = Integer.MIN_VALUE;
        int curValue = 0;
        int maxSum = 0;

        for (int num : nums) {
            if (num == curKey) {
                curValue += 1;
            } else {
                // 差值为1
                if (curKey - lastKey == 1) {
                    maxSum = Math.max(curValue + lastValue, maxSum);
                }

                // 切换key
                lastKey = curKey;
                lastValue = curValue;
                curKey = num;
                curValue = 1;
            }
        }

        // 比较最后两个数
        if (curKey - lastKey == 1) {
            maxSum = Math.max(curValue + lastValue, maxSum);
        }

        return maxSum;
    }
}


// @lc code=end

