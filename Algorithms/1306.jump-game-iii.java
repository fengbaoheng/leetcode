/*
 * @lc app=leetcode.cn id=1306 lang=java
 *
 * [1306] 跳跃游戏 III
 */

// @lc code=start
import java.util.*;

class Solution {
    // 广度优先搜索
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int i = queue.poll();
            int value = arr[i];

            // 寻找到
            if (value == 0) {
                return true;
            }

            // 已搜索过
            if (value < 0) {
                continue;
            }

            // 左跳跃点
            int p = i - arr[i];
            if (p >= 0 && arr[p] >= 0) {
                queue.add(p);
            }

            // 右跳跃点
            int q = i + arr[i];
            if (q < arr.length && arr[q] >= 0) {
                queue.add(q);
            }

            // 标记搜索过的节点为负值
            arr[i] = -1;
        }

        return false;
    }
}
// @lc code=end

