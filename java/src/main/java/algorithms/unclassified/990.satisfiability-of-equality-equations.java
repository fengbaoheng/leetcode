/*
 * @lc app=leetcode.cn id=990 lang=java
 *
 * [990] 等式方程的可满足性
 */

// @lc code=start
import java.util.*;

class Solution {
    public boolean equationsPossible(String[] equations) {
        UF uf = new UF();

        // 记录不等式,在处理完所有等式后再处理
        List<int[]> notEquals = new LinkedList<>();

        for (String str : equations) {
            int a = str.charAt(0) - 'a';
            int b = str.charAt(3) - 'a';

            if (str.charAt(1) == '=') {
                uf.union(a, b);
            } else {
                if (a == b) {
                    return false;
                }
                notEquals.add(new int[]{a, b});
            }
        }

        for (int[] ab : notEquals) {
            if (uf.isUnion(ab[0], ab[1])) {
                return false;
            }
        }


        return true;
    }

    // 并查集
    private static class UF {
        private final int[] parents = new int[26];

        public UF() {
            for (int i = 0; i < 26; i++) {
                parents[i] = i;
            }
        }

        public boolean isUnion(int a, int b) {
            int aRoot = findRoot(a);
            int bRoot = findRoot(b);
            return aRoot == bRoot;
        }

        public void union(int a, int b) {
            int aRoot = findRoot(a);
            int bRoot = findRoot(b);
            parents[bRoot] = aRoot;
        }

        private int findRoot(int m) {
            while (m != parents[m]) {
                m = parents[m];
            }
            return m;
        }
    }
}
// @lc code=end

