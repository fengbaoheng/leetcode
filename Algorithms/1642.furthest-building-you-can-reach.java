/*
 * @lc app=leetcode.cn id=1642 lang=java
 *
 * [1642] 可以到达的最远建筑
 */

// @lc code=start
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        Queue<Integer> brickDemand = new PriorityQueue<>(Comparator.reverseOrder());

        int index = 0;
        for (int i = 1; i < heights.length; i++) {
            int diff = heights[i] - heights[i - 1];

            // 可以直接跳过
            if (diff <= 0) {
                index = i;
                continue;
            }

            // 先使用砖跳过
            brickDemand.add(diff);
            bricks -= diff;

            if (bricks >= 0) {
                index = i;
                continue;
            }

            // 砖不够,使用梯子替换砖
            while (bricks < 0 && ladders > 0 && !brickDemand.isEmpty()) {
                bricks += brickDemand.poll();
                ladders--;
            }

            // 使用梯子替换砖后，是否还可以继续向后跳
            if (bricks >= 0) {
                index = i;
            } else {
                break;
            }
        }

        return index;
    }
}
// @lc code=end

