/*
 * @lc app=leetcode.cn id=1471 lang=java
 *
 * [1471] 数组中的 k 个最强值
 */

// @lc code=start
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

class Solution {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int m = arr[(arr.length - 1) / 2];

        Comparator<Integer> cmp = (a, b) -> {
            int i = Math.abs(a - m);
            int j = Math.abs(b - m);
            if (i > j || (i == j && a > b)) {
                return 1;
            }
            return -1;
        };

        return IntStream.of(arr)
                .boxed()
                .sorted(cmp.reversed())
                .limit(k)
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
// @lc code=end

