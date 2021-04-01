package algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * 1722.执行交换操作后的最小汉明距离
 */

class Problem1722 {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;

        // 建立图的连通性
        UnionFind unionFind = new UnionFind(n);
        for (int[] swap : allowedSwaps) {
            int a = swap[0];
            int b = swap[1];
            unionFind.connect(a, b);
        }

        // 同一组的数字聚集，组号即使用rootIndex
        Map<Integer, Map<Integer, Integer>> groups = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            int num = source[i];
            int rootIndex = unionFind.findRoot(i);
            groups.computeIfAbsent(rootIndex, k -> new HashMap<>())
                    .merge(num, 1, Integer::sum);
        }

        int distance = 0;
        for (int i = 0; i < n; i++) {
            int targetNum = target[i];
            int rootIndex = unionFind.findRoot(i);
            Map<Integer, Integer> group = groups.get(rootIndex);
            Integer count = group.getOrDefault(targetNum, 0);
            if (count > 0) {
                group.put(targetNum, count - 1);
            } else {
                distance++;
            }
        }

        return distance;
    }

    /**
     * 并查集
     */
    private static class UnionFind {
        private final int[] roots;

        public UnionFind(int n) {
            this.roots = new int[n];
            for (int i = 0; i < n; i++) {
                roots[i] = i;
            }
        }

        /**
         * @return 根节点
         */
        private int findRoot(int index) {
            while (roots[index] != index) {
                roots[index] = roots[roots[index]];
                index = roots[index];
            }
            return index;
        }

        /**
         * 连接两个节点
         */
        private void connect(int a, int b) {
            int aRoot = findRoot(a);
            int bRoot = findRoot(b);
            if (aRoot != bRoot) {
                roots[aRoot] = bRoot;
            }
        }
    }
}
