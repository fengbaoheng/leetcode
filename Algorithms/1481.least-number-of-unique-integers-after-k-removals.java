/*
 * @lc app=leetcode.cn id=1481 lang=java
 *
 * [1481] 不同整数的最少数目
 */

// @lc code=start
import java.util.*;

class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> countMap = new HashMap<>(arr.length);
        for (int num : arr) {
            countMap.merge(num, 1, Integer::sum);
        }

        int[] counts = countMap.values().stream()
                .mapToInt(Integer::intValue)
                .sorted()
                .toArray();

        int count = countMap.size();
        for (int c : counts) {
            if (k < c) {
                break;
            }
            k -= c;
            count--;
        }

        return count;
    }
}
// @lc code=end

