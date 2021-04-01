/*
 * @lc app=leetcode.cn id=523 lang=java
 *
 * [523] 连续的子数组和
 */

// @lc code=start
import java.util.*;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int len = nums.length;
        if (len < 2) {
            return false;
        }

        // 记录累积和与索引值
        Map<Integer, Integer> sumMap = new HashMap<>();
        int sum = 0;
        sumMap.put(sum, -1);

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            // 累加和值并尽可能求余数
            sum += num;
            sum = k != 0 ? sum % k : sum;

            // sum值在0~k中循环
            // 当sum的值出现两次时, 则第一次出现到第二次出现的累加和即为k倍数
            if (sumMap.containsKey(sum)) {
                int firstIndex = sumMap.get(sum);

                // 保证累加长度至少为2
                int leftIndex = i - 1;
                if (firstIndex != leftIndex) {
                    return true;
                }
            } else {
                sumMap.put(sum, i);
            }
        }

        return false;
    }
}
// @lc code=end

