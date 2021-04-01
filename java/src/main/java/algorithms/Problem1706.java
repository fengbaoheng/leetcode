package algorithms;

/**
 * 1706.球会落何处
 */

class Problem1706 {
    public int[] findBall(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] results = new int[n];

        for (int c = 0; c < n; c++) {
            int col = c;
            for (int r = 0; r < m; r++) {
                int wall = grid[r][col];
                if (wall == 1) {
                    // 右侧为墙壁或右侧为左挡板
                    if (col == n - 1 || grid[r][col + 1] == -1) {
                        col = -1;
                        break;
                    } else {
                        col++;
                    }
                } else {
                    // 左侧为墙壁或左侧为右挡板
                    if (col == 0 || grid[r][col - 1] == 1) {
                        col = -1;
                        break;
                    } else {
                        col--;
                    }
                }
            }

            results[c] = col;
        }

        return results;
    }
}
