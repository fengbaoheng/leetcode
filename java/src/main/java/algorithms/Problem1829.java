package algorithms;

/**
 * 1829.每个查询的最大异或值
 */
public class Problem1829 {
    static class Solution {
        public int[] getMaximumXor(int[] nums, int maximumBit) {
            int xor = 0;
            for (int num : nums) {
                xor = xor ^ num;
            }

            int mask = (int) Math.pow(2, maximumBit) - 1;

            int[] result = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                result[i] = xor ^ mask;
                xor = xor ^ nums[nums.length - 1 - i];
            }

            return result;
        }
    }
}