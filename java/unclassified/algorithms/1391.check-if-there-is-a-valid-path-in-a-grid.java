/*
 * @lc app=leetcode.cn id=1391 lang=java
 *
 * [1391] 检查网格中是否存在有效路径
 */

// @lc code=start
import java.util.*;

class Solution {
    int rowCount;
    int colCount;
    Street[][] streets;

    public boolean hasValidPath(int[][] grid) {
        createStreets(grid);
        return search();
    }

    /**
     * @return 搜索结果
     */
    private boolean search() {
        Queue<Street> queue = new LinkedList<>();
        queue.offer(streets[0][0]);
        while (!queue.isEmpty()) {
            Street street = queue.poll();
            int row = street.row;
            int col = street.col;

            // 判断循环终止
            if (row == rowCount - 1 && col == colCount - 1) {
                return true;
            }

            // 判断访问标志
            if (street.visited) {
                continue;
            }
            street.visited = true;

            // 添加四周街道继续搜索
            Street[] neighbors = new Street[]{
                    getLeft(street), getRight(street),
                    getUp(street), getDown(street)
            };

            for (Street neighbor : neighbors) {
                if (neighbor != null && !neighbor.visited) {
                    queue.offer(neighbor);
                }
            }
        }

        return false;
    }

    /**
     * 初始化街道
     */
    private void createStreets(int[][] grid) {
        rowCount = grid.length;
        colCount = grid[0].length;
        streets = new Street[rowCount][colCount];
        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < colCount; col++) {
                int type = grid[row][col];
                streets[row][col] = new Street(row, col, type);
            }
        }
    }

    private Street getUp(Street street) {
        Street neighbor = getNeighbor(street, -1, 0);
        if (neighbor != null && street.canUp && neighbor.canDown) {
            return neighbor;
        }
        return null;
    }

    private Street getDown(Street street) {
        Street neighbor = getNeighbor(street, 1, 0);
        if (neighbor != null && street.canDown && neighbor.canUp) {
            return neighbor;
        }
        return null;
    }


    private Street getLeft(Street street) {
        Street neighbor = getNeighbor(street, 0, -1);
        if (neighbor != null && street.canLeft && neighbor.canRight) {
            return neighbor;
        }
        return null;
    }

    private Street getRight(Street street) {
        Street neighbor = getNeighbor(street, 0, 1);
        if (neighbor != null && street.canRight && neighbor.canLeft) {
            return neighbor;
        }
        return null;
    }

    private Street getNeighbor(Street street, int dr, int dc) {
        int row = street.row + dr;
        int col = street.col + dc;

        if (row >= 0 && row < rowCount && col >= 0 && col < colCount) {
            return streets[row][col];
        }
        return null;
    }

}

class Street {
    final int row;
    final int col;
    final boolean canUp;
    final boolean canDown;
    final boolean canLeft;
    final boolean canRight;

    boolean visited;

    public Street(int row, int col, int type) {
        this.row = row;
        this.col = col;
        this.canUp = type == 2 || type == 5 || type == 6;
        this.canDown = type == 2 || type == 3 || type == 4;
        this.canLeft = type == 1 || type == 3 || type == 5;
        this.canRight = type == 1 || type == 4 || type == 6;
    }
}
// @lc code=end

