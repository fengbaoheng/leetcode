/*
 * @lc app=leetcode.cn id=1615 lang=java
 *
 * [1615] 最大网络秩
 */

// @lc code=start
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        // 记录城市连通的道路数量
        Map<Integer, Integer> cityRoadMap = new HashMap<>(n);

        // 记录哪些城市连通
        Map<Integer, Set<Integer>> roadMap = new HashMap<>(roads.length);

        for (int[] road : roads) {
            int from = road[0];
            int to = road[1];

            roadMap.computeIfAbsent(from, key -> new HashSet<>()).add(to);

            cityRoadMap.merge(from, 1, Integer::sum);
            cityRoadMap.merge(to, 1, Integer::sum);
        }

        int maxRank = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int iRoad = cityRoadMap.getOrDefault(i, 0);
                int jRoad = cityRoadMap.getOrDefault(j, 0);
                int rank = iRoad + jRoad;
                if (hasDirectRoad(roadMap, i, j)) {
                    rank--;
                }

                maxRank = Math.max(maxRank, rank);
            }
        }

        return maxRank;
    }

    // 两个城市是否直接连通
    private boolean hasDirectRoad(Map<Integer, Set<Integer>> roadMap, int from, int to) {
        return (roadMap.containsKey(from) && roadMap.get(from).contains(to))
                || (roadMap.containsKey(to) && roadMap.get(to).contains(from));
    }
}
// @lc code=end

