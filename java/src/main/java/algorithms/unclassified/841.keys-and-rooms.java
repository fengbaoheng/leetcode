/*
 * @lc app=leetcode.cn id=841 lang=java
 *
 * [841] 钥匙和房间
 */

// @lc code=start
import java.util.*;

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();

        Set<Integer> opened = new HashSet<>(n);
        Queue<Integer> queue = new ArrayDeque<>(n);

        queue.add(0);
        opened.add(0);

        boolean canNext = true;
        while (canNext) {
            canNext = false;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int room = queue.poll();
                List<Integer> keys = rooms.get(room);
                for (Integer key : keys) {
                    if (!opened.contains(key)) {
                        canNext = true;
                        queue.add(key);
                        opened.add(key);
                    }
                }
            }
        }

        return opened.size() == n;
    }
}
// @lc code=end

