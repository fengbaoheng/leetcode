/*
 * @lc app=leetcode.cn id=1559 lang=java
 *
 * [1559] 二维网格图中探测环
 */

// @lc code=start
import java.util.LinkedList;
import java.util.List;

class Solution {
    // 向右，向下搜索，不能回退搜索，当搜索相遇时即是环路
    private static final int[][] MOVES = {{1, 0}, {0, 1}};

    private char[][] grid;

    // 记录访问的版本号
    private int[][] visited;
    private int version = 1;

    private List<Integer> rList, cList;
    private int rows, cols;

    public boolean containsCycle(char[][] grid) {
        this.grid = grid;
        rows = grid.length;
        cols = grid[0].length;
        this.visited = new int[rows][cols];
        rList = new LinkedList<>();
        cList = new LinkedList<>();

        // 依次遍历查找环
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // 如果访问过一次，不管版本如何，都无需继续搜索
                if (isVisited(r, c)) {
                    continue;
                }

                // 开始新版本的搜索
                version++;
                visit(r, c, version);

                // 搜索
                if (search(grid[r][c])) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean search(char target) {
        while (!rList.isEmpty()) {

            int x = rList.remove(0);
            int y = cList.remove(0);

            // 向下，向右搜索
            for (int[] move : MOVES) {
                int r = x + move[0];
                int c = y + move[1];

                // 出界
                if (!isValidLocation(r, c)) {
                    continue;
                }
                
                char ch = grid[r][c];
                
                if (ch != target) {
                    continue;
                }

                // 字符相等的情况下
                // 同一版本下搜索过该位置，则有环
                // 否则继续搜索
                if (isVisited(r, c, version)) {
                    return true;
                } else {
                    visit(r, c, version);
                }
            }
        }

        return false;
    }

    private boolean isVisited(int r, int c) {
        return visited[r][c] > 0;
    }

    private boolean isVisited(int r, int c, int version) {
        return visited[r][c] == version;
    }

    private void visit(int r, int c, int version) {
        rList.add(r);
        cList.add(c);
        visited[r][c] = version;
    }

    private boolean isValidLocation(int r, int c) {
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }
}
// @lc code=end

