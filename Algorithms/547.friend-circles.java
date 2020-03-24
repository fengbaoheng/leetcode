import java.util.*;

/*
 * @lc app=leetcode.cn id=547 lang=java
 *
 * [547] 朋友圈
 */

// @lc code=start
class Solution {
    public int findCircleNum(int[][] M) {
        boolean[] finded = new boolean[M.length];
        int circleNum = 0;

        // 广度优先搜索
        for (int i = 0; i < M.length; i++) {
            // 已经搜索过
            if (finded[i]) {
                continue;
            }

            // 开始搜索
            circleNum++;

            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            while (!queue.isEmpty()) {
                int person = queue.poll();
                finded[person] = true;

                for (int j = 0; j < M.length; j++) {
                    // 寻找person的朋友们
                    if (M[person][j] == 1 && finded[j] == false) {
                        queue.offer(j);
                    }
                }
            }
        }

        return circleNum;
    }
}
// @lc code=end
