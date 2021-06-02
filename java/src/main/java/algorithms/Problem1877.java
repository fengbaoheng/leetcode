package algorithms;

import java.util.Arrays;

/**
 * 1877.数组中最大数对和的最小值
 */
public class Problem1877 {

    class Solution {
        public int minPairSum(int[] nums) {
            Arrays.sort(nums);
            int max = 0;
            int n = nums.length;
            for (int i = 0; i < n / 2; i++) {
                max = Math.max(max, nums[i] + nums[n - i - 1]);
            }
            return max;
        }
    }

}