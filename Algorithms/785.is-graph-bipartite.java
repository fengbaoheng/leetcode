/*
 * @lc app=leetcode.cn id=785 lang=java
 *
 * [785] 判断二分图
 */

// @lc code=start
import java.util.*;

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;

        int[] G = new int[n];
        Queue<Integer> queue = new ArrayDeque<>(n);
        for (int i = 0; i < n; i++) {
            if (G[i] != 0) {
                continue;
            }

            queue.add(i);
            int g = 1;

            while (!queue.isEmpty()) {
                int size = queue.size();
                g = g == 1 ? 2 : 1;
                for (int j = 0; j < size; j++) {
                    int node = queue.poll();
                    if (G[node] != 0) {
                        if (G[node] != g) {
                            return false;
                        } else {
                            continue;
                        }
                    }
                    
                    G[node] = g;
                    for (int edge : graph[node]) {
                        queue.add(edge);
                    }
                }
            }
        }

        return true;
    }
}
// @lc code=end

