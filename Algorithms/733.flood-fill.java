/*
 * @lc app=leetcode.cn id=733 lang=java
 *
 * [733] 图像渲染
 */

// @lc code=start
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int rows = image.length;
        int cols = image[0].length;
        int sColor = image[sr][sc];

        // 不需要渲染
        if (sColor == newColor) {
            return image;
        }

        // 渲染后的图像, 默认全部填充-1
        // 即-1点为未访问过的点
        int[][] fill = new int[rows][cols];
        for (int[] row : fill) {
            Arrays.fill(row, -1);
        }

        // 将待搜索的点加入队列中
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});

        // 不断搜索
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int r = point[0];
            int c = point[1];

            // 排除不合法的点, 颜色不同的点, 已经被渲染的点
            if (r < 0 || r >= rows || c < 0 || c >= cols || image[r][c] != sColor || fill[r][c] != -1) {
                continue;
            }

            // 修改颜色值从-1->newColor
            fill[r][c] = newColor;

            // 添加4个相邻点 尝试继续搜索
            queue.add(new int[]{r - 1, c});
            queue.add(new int[]{r + 1, c});
            queue.add(new int[]{r, c - 1});
            queue.add(new int[]{r, c + 1});
        }


        // 其他颜色复制
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (fill[r][c] != -1) {
                    continue;
                }

                fill[r][c] = image[r][c];
            }
        }


        return fill;
    }
}
// @lc code=end

