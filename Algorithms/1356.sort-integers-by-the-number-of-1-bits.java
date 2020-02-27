/*
 * @lc app=leetcode.cn id=1356 lang=java
 *
 * [1356] 根据数字二进制下 1 的数目排序
 */

// @lc code=start
import java.util.Comparator;
import java.util.stream.IntStream;

class Solution {
    public int[] sortByBits(int[] arr) {
        Comparator<Integer> comparator = Comparator
                .comparingInt(this::count1)
                .thenComparingInt(Integer::intValue);

        return IntStream.of(arr)
                .boxed()
                .sorted(comparator)
                .mapToInt(Integer::intValue)
                .toArray();
    }

    /**
     * @param num 整数
     * @return 二进制中1的个数
     */
    private int count1(int num) {
        int count = 0;
        while (num != 0) {
            if (num % 2 != 0) {
                count++;
            }

            num = num >> 1;
        }
        return count;
    }
}
// @lc code=end

