/*
 * @lc app=leetcode.cn id=661 lang=java
 *
 * [661] 图片平滑器
 */
class Solution {
    public int[][] imageSmoother(int[][] M) {
        int rowCount = M.length;
        if (rowCount == 0) {
            return M;
        }

        int colCount = M[0].length;
        if (colCount == 0) {
            return M;
        }

        int[][] R = new int[rowCount][colCount];
        int[][] move = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        for (int r = 0; r < rowCount; r++) {
            for (int c = 0; c < colCount; c++) {
                int sum = M[r][c];
                int count = 1;

                for (int[] m : move) {
                    int dr = r + m[0];
                    int dc = c + m[1];
                    if (dr >= 0 && dr < rowCount && dc >= 0 && dc < colCount) {
                        count++;
                        sum += M[dr][dc];
                    }
                }

                R[r][c] = sum / count;
            }
        }

        return R;
    }
}

