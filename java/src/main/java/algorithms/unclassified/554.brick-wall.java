/*
 * @lc app=leetcode.cn id=554 lang=java
 *
 * [554] 砖墙
 */
import java.util.*;

class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        int height = wall.size();

        // 记录砖缝数量
        Map<Integer, Integer> gap = new HashMap<>();
        int maxGapCount = 0;

        for (List<Integer> layer : wall) {
            int index = 0;
            for (int i = 0; i < layer.size() - 1; i++) {
                index += layer.get(i);
                int newCount = gap.getOrDefault(index, 0) + 1;
                gap.put(index, newCount);

                if (newCount > maxGapCount) {
                    maxGapCount = newCount;
                }
            }
        }

        return height - maxGapCount;
    }
}

