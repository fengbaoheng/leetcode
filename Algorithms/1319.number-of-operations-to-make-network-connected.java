/*
 * @lc app=leetcode.cn id=1319 lang=java
 *
 * [1319] 连通网络的操作次数
 */

// @lc code=start
class Solution {
    public int makeConnected(int n, int[][] connections) {
        final UF uf = new UF(n);

        int count = 0;
        for (int[] connection : connections) {
            int p = connection[0];
            int q = connection[1];
            if (!uf.union(p, q)) {
                count++;
            }
        }

        if (uf.count == 0) {
            return 0;
        } else if (uf.count - 1 > count) {
            return -1;
        } else {
            return uf.count - 1;
        }
    }
}


class UF {
    final int n;
    final int[] parent;
    int count;

    public UF(int n) {
        this.n = n;
        this.count = n;
        this.parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int findRoot(int x) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public boolean union(int p, int q) {
        if (p == q) {
            return false;
        }

        int pRoot = findRoot(p);
        int qRoot = findRoot(q);

        if (pRoot == qRoot) {
            return false;
        }

        parent[pRoot] = qRoot;
        count--;
        return true;
    }
}
// @lc code=end

