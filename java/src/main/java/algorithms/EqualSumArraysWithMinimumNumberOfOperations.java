package algorithms;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 1775.通过最少操作次数使数组的和相等
 */
class EqualSumArraysWithMinimumNumberOfOperations {
    // 贪心策略，高值尽可能变小，低值尽可能变大
    public int minOperations(int[] nums1, int[] nums2) {
        int sum1 = Arrays.stream(nums1).sum();
        int sum2 = Arrays.stream(nums2).sum();

        if (sum1 == sum2) {
            return 0;
        }

        int[] minNums = sum1 < sum2 ? nums1 : nums2;
        int[] maxNums = sum1 < sum2 ? nums2 : nums1;

        int diff = Math.abs(sum1 - sum2);


        int[] diffNums = IntStream.concat(
                Arrays.stream(minNums).map(num -> 6 - num),
                Arrays.stream(maxNums).map(num -> num - 1)
        ).sorted().toArray();

        int count = 0;
        for (int i = diffNums.length - 1; i >= 0; i--) {
            diff -= diffNums[i];
            count++;
            if (diff <= 0) {
                return count;
            }
        }

        return -1;
    }
}

