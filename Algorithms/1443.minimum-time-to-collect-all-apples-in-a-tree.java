/*
 * @lc app=leetcode.cn id=1443 lang=java
 *
 * [1443] 收集树上所有苹果的最少时间
 */

// @lc code=start
import java.util.*;

class Solution {
    private class Node {
        private final boolean hasApple;
        private final Set<Node> neighbors = new HashSet<>();

        public Node(boolean hasApple) {
            this.hasApple = hasApple;
        }

        public void addEdge(Node child) {
            this.neighbors.add(child);
            child.neighbors.add(this);
        }

        public int collect(Node from) {
            int count = 0;

            for (Node neighbor : neighbors) {
                if (neighbor != from) {
                    count += neighbor.collect(this);
                }
            }

            if (hasApple || count > 0) {
                count += 2;
            }

            return count;
        }
    }

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Node[] nodes = new Node[n];

        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(hasApple.get(i));
        }

        for (int[] edge : edges) {
            nodes[edge[0]].addEdge(nodes[edge[1]]);
        }

        int count = nodes[0].collect(null);
        return count == 0 ? 0 : count - 2;
    }
}
// @lc code=end

