/*
 * @lc app=leetcode.cn id=1466 lang=java
 *
 * [1466] 重新规划路线
 */

// @lc code=start
import java.util.*;

class Solution {
    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<Integer>> leaveMap = new HashMap<>(n);
        Map<Integer, List<Integer>> arriveMap = new HashMap<>(n);

        for (int[] connection : connections) {
            int from = connection[0];
            int to = connection[1];
            leaveMap.putIfAbsent(from, new LinkedList<>());
            leaveMap.get(from).add(to);
            arriveMap.putIfAbsent(to, new LinkedList<>());
            arriveMap.get(to).add(from);
        }

        Queue<Integer> queue = new ArrayDeque<>(n);
        Set<Integer> visited = new HashSet<>(n);
        visited.add(0);
        queue.add(0);

        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int city = queue.poll();

                List<Integer> arriveList = arriveMap.get(city);
                if (arriveList != null) {
                    for (Integer id : arriveList) {
                        if (!visited.contains(id)) {
                            visited.add(id);
                            queue.add(id);
                        }
                    }
                }

                List<Integer> toList = leaveMap.get(city);
                if (toList != null) {
                    for (Integer id : toList) {
                        if (!visited.contains(id)) {
                            visited.add(id);
                            queue.add(id);
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}
// @lc code=end

