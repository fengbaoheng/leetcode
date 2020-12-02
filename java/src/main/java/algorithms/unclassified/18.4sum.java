/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 */

// @lc code=start
import java.util.*;

class Solution {

    private Map<Integer, Integer> countMap;
    private Set<Integer> numSet;
    private List<List<Integer>> results;
    private int target;

    public List<List<Integer>> fourSum(int[] nums, int target) {
        countMap = new HashMap<>();
        results = new LinkedList<>();
        this.target = target;

        for (int num : nums) {
            countMap.merge(num, 1, Integer::sum);
        }

        this.numSet = new TreeSet<>(countMap.keySet());

        track(0, new int[4]);

        return results;
    }

    private void track(int i, int[] result) {
        if (i == 3) {
            int sum = result[0] + result[1] + result[2];
            int num = target - sum;
            if (num >= result[2] && countMap.containsKey(num) && countMap.get(num) > 0) {
                results.add(Arrays.asList(result[0], result[1], result[2], num));
            }
            return;
        }


        for (Integer num : numSet) {
            if (i > 0 && num < result[i - 1]) {
                continue;
            }

            int count = countMap.get(num);
            if (count <= 0) {
                continue;
            }

            countMap.put(num, count - 1);
            result[i] = num;
            track(i + 1, result);
            countMap.put(num, count);
        }
    }
}
// @lc code=end

