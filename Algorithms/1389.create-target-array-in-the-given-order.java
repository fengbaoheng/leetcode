import java.util.*;

/*
 * @lc app=leetcode.cn id=1389 lang=java
 *
 * [1389] 按既定顺序创建目标数组
 */

// @lc code=start
class Solution {

    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> results = new LinkedList<>();
        for (int i = 0; i < index.length; i++) {
            results.add(index[i], nums[i]);
        }
        return results.stream().mapToInt(Integer::intValue).toArray();
    }
}
// @lc code=end
