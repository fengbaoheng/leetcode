/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

// @lc code=start
import java.util.*;


class Solution {

    List<List<Integer>> result;
    int size;

    public List<List<Integer>> permuteUnique(int[] nums) {
        this.result = new LinkedList<>();
        this.size = nums.length;

        Map<Integer, Integer> count = new HashMap<>(nums.length);

        for (int num : nums) {
            count.merge(num, 1, Integer::sum);
        }

        search(count, new LinkedList<>());

        return result;
    }

    public void search(Map<Integer, Integer> count, Deque<Integer> track) {
        // 组成了完整的全排列
        if (track.size() == this.size) {
            result.add(new LinkedList<>(track));
            return;
        }

        // 尝试每种选择
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int value = entry.getValue();

            // 已在路径中使用完所有数字
            if (value == 0) {
                continue;
            }

            // 选择数字
            Integer num = entry.getKey();
            track.offerLast(num);
            count.put(num, value - 1);

            // 向下递归
            search(count, track);

            // 恢复数字，进行下一个选择
            track.pollLast();
            count.put(num, value);
        }
    }
}
// @lc code=end

