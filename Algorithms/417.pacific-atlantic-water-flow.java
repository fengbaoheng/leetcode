/*
 * @lc app=leetcode.cn id=417 lang=java
 *
 * [417] 太平洋大西洋水流问题
 */

// @lc code=start
import java.util.*;


class Solution {
    private int rows, cols;
    private int[][] matrix;

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> results = new LinkedList<>();

        if (matrix == null || matrix.length <= 0) {
            return results;
        }

        rows = matrix.length;
        cols = matrix[0].length;
        this.matrix = matrix;

        Queue<int[]> queue = new ArrayDeque<>(rows * cols);

        boolean[][] pacific = new boolean[rows][cols];
        for (int c = 0; c < cols; c++) {
            pacific[0][c] = true;
            queue.add(new int[]{0, c});
        }
        for (int r = 0; r < rows; r++) {
            pacific[r][0] = true;
            queue.add(new int[]{r, 0});
        }
        bfs(queue, pacific);


        boolean[][] atlantic = new boolean[rows][cols];
        for (int c = 0; c < cols; c++) {
            atlantic[rows - 1][c] = true;
            queue.add(new int[]{rows - 1, c});
        }
        for (int r = 0; r < rows; r++) {
            atlantic[r][cols - 1] = true;
            queue.add(new int[]{r, cols - 1});
        }
        bfs(queue, atlantic);


        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    List<Integer> result = new ArrayList<>(2);
                    result.add(r);
                    result.add(c);
                    results.add(result);
                }
            }
        }

        return results;
    }


    private void bfs(Queue<int[]> queue, boolean[][] visited) {
        int[][] moves = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] move : moves) {
                    int r = cur[0] + move[0];
                    int c = cur[1] + move[1];
                    if (r >= 0 && r < rows && c >= 0 && c < cols && !visited[r][c]) {
                        int curHeight = matrix[cur[0]][cur[1]];
                        int nextHeight = matrix[r][c];
                        if (nextHeight >= curHeight) {
                            visited[r][c] = true;
                            queue.add(new int[]{r, c});
                        }
                    }
                }
            }
        }
    }
}
// @lc code=end

