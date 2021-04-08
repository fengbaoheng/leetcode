package algorithms;

import java.util.TreeSet;

/**
 * 1818.绝对差值和
 */
public class Problem1818 {

    private static class Solution {
        private static final int M = 1000_000_000 + 7;

        public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
            int n = nums1.length;
            TreeSet<Integer> set = new TreeSet<>();
            for (int j : nums1) {
                set.add(j);
            }

            long sum = 0;
            long maxChange = 0;
            for (int i = 0; i < n; i++) {
                int num1 = nums1[i];
                int num2 = nums2[i];
                if (num1 == num2) {
                    continue;
                }

                int diff = Math.abs(num1 - num2);
                sum += diff;
                sum %= M;

                Integer ceil = set.ceiling(num2);
                if (ceil != null) {
                    maxChange = Math.max(maxChange, diff - (ceil - num2));
                }

                Integer floor = set.floor(num2);
                if (floor != null) {
                    maxChange = Math.max(maxChange, diff - (num2 - floor));
                }
            }


            sum -= maxChange;

            if (sum < 0) {
                sum += M;
            }

            return (int) sum;
        }
    }


}