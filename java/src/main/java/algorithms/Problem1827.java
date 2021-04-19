package algorithms;

/**
 * 1827.最少操作使数组递增
 */
public class Problem1827 {

    static class Solution {
        public int minOperations(int[] nums) {
            int n = nums.length;
            if (n <= 1) {
                return 0;
            }


            int target = nums[0];
            int sum = 0;

            for (int num : nums) {
                if (num >= target) {
                    target = num + 1;
                } else {
                    sum += target - num;
                    target++;
                }
            }

            return sum;
        }
    }
}