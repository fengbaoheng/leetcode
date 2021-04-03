package algorithms;

/**
 * 1748.唯一元素的和
 */

class Problem1748 {
    static class Solution {
        public int sumOfUnique(int[] nums) {
            final int n = 100;

            int[] counts = new int[n + 1];
            for (int num : nums) {
                counts[num]++;
            }

            int sum = 0;
            for (int num = 0; num <= n; num++) {
                final int count = counts[num];
                if (count == 1) {
                    sum += num;
                }
            }

            return sum;
        }
    }
}
