import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1403 lang=java
 *
 * [1403] 非递增顺序的最小子序列
 */

// @lc code=start
class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> list = new ArrayList<>(nums.length);

        int sum = 0;
        for (int num : nums) {
            list.add(num);
            sum += num;
        }

        // 从大到小排序
        Collections.sort(list);
        Collections.reverse(list);

        // 依次取出当前最小的值
        int removed = 0;
        int num = 0;
        while (removed < sum) {
            num = list.remove(list.size() - 1);
            removed += num;
            sum -= num;
        }

        list.add(num);
        
        return list;
    }
}
// @lc code=end
