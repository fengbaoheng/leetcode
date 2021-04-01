/*
 * @lc app=leetcode.cn id=684 lang=java
 *
 * [684] 冗余连接
 */

// @lc code=start
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFound unionFound = new UnionFound(edges.length);
        for (int[] edge : edges) {
            int i = edge[0] - 1;
            int j = edge[1] - 1;
            if (unionFound.isConnected(i, j)) {
                return edge;
            } else {
                unionFound.connect(i, j);
            }
        }

        return edges[0];
    }
}

class UnionFound {
    private final int[] parents;

    public UnionFound(int n) {
        this.parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
    }

    public int getParent(int index) {
        while (parents[index] != index) {
            index = parents[index];
        }
        return index;
    }

    public boolean isConnected(int i, int j) {
        return getParent(i) == getParent(j);
    }

    public void connect(int i, int j) {
        int pi = getParent(i);
        int pj = getParent(j);

        if (pi != pj) {
            parents[pj] = pi;
        }
    }
}
// @lc code=end

