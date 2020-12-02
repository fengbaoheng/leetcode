/*
 * @lc app=leetcode.cn id=378 lang=java
 *
 * [378] 有序矩阵中第K小的元素
 */

// @lc code=start
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        final int n = matrix.length;

        // 记录是否访问过
        boolean[][] visited = new boolean[n][n];

        // 堆排序搜索当前最小值
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(arr -> arr[0]));
        
        // 从左上角开始搜索
        queue.add(new int[]{matrix[0][0], 0, 0});
        visited[0][0] = true;

        for (int i = 0; i < k - 1; i++) {
            int[] min = queue.poll();
            int x = min[1];
            int y = min[2];

            // 将下侧加入堆中
            if (x < n - 1 && !visited[x + 1][y]) {
                visited[x + 1][y] = true;
                queue.offer(new int[]{matrix[x + 1][y], x + 1, y});
            }

            // 将右侧加入堆中
            if (y < n - 1 && !visited[x][y + 1]) {
                visited[x][y + 1] = true;
                queue.offer(new int[]{matrix[x][y + 1], x, y + 1});
            }
        }

        return queue.peek()[0];
    }
}
// @lc code=end

