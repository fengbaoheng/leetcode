import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1338 lang=java
 *
 * [1338] 数组大小减半
 */

// @lc code=start
class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.merge(num, 1, Integer::sum);
        }

        int[] counts = map.values().stream().mapToInt(Integer::intValue).sorted().toArray();

        int len = arr.length / 2;
        for (int i = counts.length - 1; i >= 0; i--) {
            len -= counts[i];
            if (len <= 0) {
                return counts.length - i;
            }
        }

        return counts.length;
    }
}
// @lc code=end
