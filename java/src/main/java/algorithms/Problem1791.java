package algorithms;

/**
 * 1791.找出星型图的中心节点
 */
class Problem1791 {
    public int findCenter(int[][] edges) {
        final int n = edges.length + 1;

        // 统计每个节点上的边
        int[] nodeEdgeCount = new int[n + 1];
        for (int[] edge : edges) {
            nodeEdgeCount[edge[0]]++;
            nodeEdgeCount[edge[1]]++;
        }

        // 边数量为n-1即是中心节点
        for (int node = 0; node < nodeEdgeCount.length; node++) {
            if (nodeEdgeCount[node] == n - 1) {
                return node;
            }
        }

        return -1;
    }
}