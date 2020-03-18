import java.util.*;
import java.util.stream.IntStream;

/*
 * @lc app=leetcode.cn id=1005 lang=java
 *
 * [1005] K 次取反后最大化的数组和
 */

// @lc code=start
class Solution {
    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);

        // 尝试把负数变为正数
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 0 || K == 0) {
                break;
            }
            A[i] = -A[i];
            K--;
        }

        // 变换次数已经用完， 或还剩余偶数次
        if (K == 0 || K % 2 == 0) {
            return getSum(A);
        }

        // 将最小正数变为负数后求和
        int min = getMin(A);
        return getSum(A) - min - min;
    }

    private int getSum(int[] A) {
        return IntStream.of(A).sum();
    }

    private int getMin(int[] A) {
        return IntStream.of(A).min().orElse(0);
    }
}
// @lc code=end
