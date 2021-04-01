/*
 * @lc app=leetcode.cn id=1584 lang=java
 *
 * [1584] 连接所有点的最小费用
 */

// @lc code=start
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.minCostConnectPoints(new int[][]{
                {0, 0}, {2, 2}, {3, 1}, {5, 2}, {7, 0}
        });
    }

    public int minCostConnectPoints(int[][] points) {

        int n = points.length;
        int total = 0;
        int connectCount = 1;

        UnionFind uf = new UnionFind(n);

        // 求出所有边并排序
        List<int[]> edges = getEdges(points);
        edges.sort(Comparator.comparingInt(edge -> edge[2]));

        // 克鲁斯卡尔算法
        for (int[] edge : edges) {
            // 所有节点都已经连接完毕
            if (connectCount == n) {
                break;
            }

            // 找到该边连接的子树的根节点
            int treeI = uf.getParent(edge[0]);
            int treeJ = uf.getParent(edge[1]);

            // 该边连接的两点已经连通过了
            if (treeI == treeJ) {
                continue;
            }

            uf.union(treeI, treeJ);

            connectCount++;
            total += edge[2];
        }

        return total;
    }

    private List<int[]> getEdges(int[][] points) {
        int n = points.length;

        List<int[]> edges = new ArrayList<>(n * n);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int[] edge = {i, j, Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1])};
                edges.add(edge);
            }
        }
        return edges;
    }
}

// 并查集
class UnionFind {
    private final int[] parent;

    public UnionFind(int n) {
        this.parent = new int[n];
        for (int i = 0; i < n; i++) {
            this.parent[i] = i;
        }
    }

    public int getParent(int i) {
        int k = i;
        while (parent[k] != k) {
            k = parent[k];
        }
        return k;
    }

    public void union(int i, int j) {
        int pi = getParent(i);
        int pj = getParent(j);
        if (pi != pj) {
            parent[pj] = pi;
        }
    }
}
// @lc code=end

