package algorithms;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 1202.交换字符串中的元素
 */

class Problem1202 {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if (s.isEmpty() || pairs.isEmpty()) {
            return s;
        }

        char[] chars = s.toCharArray();
        int n = chars.length;

        // 建立并查集联通性
        UnionFind unionFind = new UnionFind(n);
        for (List<Integer> pair : pairs) {
            int a = pair.get(0);
            int b = pair.get(1);
            unionFind.union(a, b);
        }

        // 联通的同一组归类
        Map<Integer, List<Integer>> parentMap = IntStream.range(0, n).boxed()
                .collect(Collectors.groupingBy(unionFind::find));

        char[] smallChars = new char[n];
        for (List<Integer> indexes : parentMap.values()) {
            // 同组中的字符从小到大排序
            List<Character> sortedChars = indexes.stream()
                    .map(index -> chars[index])
                    .sorted().collect(Collectors.toList());

            // 索引从小到达排序
            Collections.sort(indexes);

            // 小索引匹配小字符
            int m = sortedChars.size();
            for (int i = 0; i < m; i++) {
                int index = indexes.get(i);
                char ch = sortedChars.get(i);
                smallChars[index] = ch;
            }
        }

        return String.valueOf(smallChars);
    }


    /**
     * 并查集
     */
    private static class UnionFind {
        final int n;
        final int[] parent;

        public UnionFind(int n) {
            this.n = n;
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        private int find(int i) {
            // 一直向上查找，直到自己和parent相等
            while (parent[i] != i) {
                parent[i] = parent[parent[i]];
                i = parent[i];
            }
            return i;
        }

        private void union(int i, int j) {
            if (i == j) {
                return;
            }

            int iParent = find(i);
            int jParent = find(j);

            if (iParent != jParent) {
                parent[iParent] = jParent;
            }
        }
    }
}