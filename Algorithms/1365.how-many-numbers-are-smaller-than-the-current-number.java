/*
 * @lc app=leetcode.cn id=1365 lang=java
 *
 * [1365] 有多少小于当前数字的数字
 */

// @lc code=start
import java.util.*;
import java.util.stream.IntStream;

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);


        Map<Integer, Integer> map = new HashMap<>();

        int count = 0;
        for (int num : sorted) {
            if (!map.containsKey(num)) {
                map.put(num, count);
            }
            count++;
        }

        return IntStream.of(nums).map(map::get).toArray();
    }
}
// @lc code=end

