/*
 * @lc app=leetcode.cn id=846 lang=java
 *
 * [846] 一手顺子
 */

// @lc code=start
import java.util.*;


class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        if (W == 1) {
            return true;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int num : hand) {
            map.merge(num, 1, Integer::sum);
        }

        while (!map.isEmpty()) {
            int k = map.firstKey();
            int minCount = Integer.MAX_VALUE;

            for (int i = 0; i < W; i++) {
                int nextK = k + i;
                Integer nextCount = map.get(nextK);
                if (nextCount == null) {
                    return false;
                }
                minCount = Math.min(minCount, nextCount);
            }

            // 扣除
            for (int i = 0; i < W; i++) {
                int nextK = k + i;
                int remainCount = map.get(nextK) - minCount;

                if (remainCount == 0) {
                    map.remove(nextK);
                } else {
                    map.put(nextK, remainCount);
                }
            }
        }

        return true;
    }
}
// @lc code=end

