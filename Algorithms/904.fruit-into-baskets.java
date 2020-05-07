/*
 * @lc app=leetcode.cn id=904 lang=java
 *
 * [904] 水果成篮
 */

// @lc code=start
import java.util.*;

class Solution {
    public int totalFruit(int[] tree) {
        Map<Integer, Integer> count = new HashMap<>();
        int max = 0;

        int left = 0;
        for (int right = 0; right < tree.length; ++right) {
            // 窗口右滑一位
            count.merge(tree[right], 1, Integer::sum);

            // 若窗口容纳水果超出2种，收缩窗口
            while (count.size() >= 3) {
                int leftType = tree[left];
                int leftCount = count.get(leftType);
                if (leftCount == 1) {
                    count.remove(leftType);
                } else {
                    count.put(leftType, leftCount - 1);
                }

                left++;
            }

            // 更新最大值
            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}
// @lc code=end

