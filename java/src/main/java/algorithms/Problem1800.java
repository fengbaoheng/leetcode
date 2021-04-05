package algorithms;

/**
 * 1800.最大升序子数组和
 */
public class Problem1800 {

    class Solution {
        public int maxAscendingSum(int[] nums) {
            int sum = nums[0];
            int maxSum = sum;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > nums[i - 1]) {
                    sum += nums[i];
                    maxSum = Math.max(maxSum, sum);
                } else {
                    sum = nums[i];
                }
            }

            return maxSum;
        }
    }


}