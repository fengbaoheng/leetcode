/*
 * @lc app=leetcode.cn id=697 lang=java
 *
 * [697] 数组的度
 */

// @lc code=start
import java.util.*;

class Solution {
    public int findShortestSubArray(int[] nums) {
        // int[] fields = [频数, 首索引, 尾索引]
        HashMap<Integer, int[]> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (map.containsKey(num)) {
                int[] fields = map.get(num);
                fields[0]++;
                fields[2] = i;
            } else {
                int[] fields = new int[]{1, i, i};
                map.put(num, fields);
            }
        }

        int[] result = map
                .values()
                .stream()
                .max(Comparator.comparing((int[] arr) -> arr[0]).reversed().thenComparing((int[] arr) -> arr[2] - arr[1]).reversed())
                .orElse(new int[]{0, 0, 0});

        return result[2] - result[1] + 1;
    }
}
// @lc code=end

