/*
 * @lc app=leetcode.cn id=1200 lang=java
 *
 * [1200] 最小绝对差
 */

// @lc code=start
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        
        int minD = IntStream.range(0, arr.length - 1)
                .map(i -> arr[i + 1] - arr[i])
                .min().orElse(0);

        return IntStream.range(0, arr.length - 1)
                .filter(i -> arr[i + 1] - arr[i] == minD)
                .mapToObj(i -> Arrays.asList(arr[i], arr[i + 1]))
                .collect(Collectors.toList());
    }
}
// @lc code=end

