/*
 * @lc app=leetcode.cn id=959 lang=java
 *
 * [959] 由斜杠划分区域
 */

// @lc code=start
class Solution {
    private int rows;
    private int cols;
    private UF uf;

    private static final int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3;

    public int regionsBySlashes(String[] grid) {
        rows = grid.length;
        cols = grid[0].length();
        uf = new UF(rows * cols * 4);

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int ch = grid[r].charAt(c);

                connectLeft(r, c);
                connectUp(r, c);

                int up = getId(r, c, UP);
                int down = getId(r, c, DOWN);
                int left = getId(r, c, LEFT);
                int right = getId(r, c, RIGHT);

                if (ch == ' ') {
                    uf.connect(up, left);
                    uf.connect(up, down);
                    uf.connect(up, right);
                } else if (ch == '/') {
                    uf.connect(up, left);
                    uf.connect(down, right);
                } else {
                    uf.connect(up, right);
                    uf.connect(left, down);
                }
            }
        }
        return uf.count;
    }

    private void connectLeft(int r, int c) {
        if (isValid(r, c - 1)) {
            uf.connect(getId(r, c, LEFT), getId(r, c - 1, RIGHT));
        }
    }

    private void connectUp(int r, int c) {
        if (isValid(r - 1, c)) {
            uf.connect(getId(r, c, UP), getId(r - 1, c, DOWN));
        }
    }

    public int getId(int r, int c, int direction) {
        return (r * cols + c) * 4 + direction;
    }

    private boolean isValid(int r, int c) {
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }

    private static class UF {
        int n;
        int count;
        int[] parent;

        public UF(int n) {
            this.n = n;
            this.count = n;
            this.parent = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public void connect(int p, int q) {
            int pRoot = findRoot(p);
            int qRoot = findRoot(q);

            if (pRoot == qRoot) {
                return;
            }

            parent[qRoot] = pRoot;
            count--;
        }

        public int findRoot(int x) {
            while (parent[x] != x) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return parent[x];
        }
    }
}
// @lc code=end

