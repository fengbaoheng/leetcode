import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1334 lang=java
 *
 * [1334] 阈值距离内邻居最少的城市
 */

// @lc code=start
class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int infinity = distanceThreshold + 1;

        // 初始邻接矩阵
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(matrix[i], infinity);
            matrix[i][i] = 0;
        }

        // 设置权重
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            matrix[from][to] = weight;
            matrix[to][from] = weight;
        }

        // 计算最短路 floyd
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int newWeight = matrix[i][k] + matrix[k][j];
                    if(newWeight < matrix[i][j]){
                        matrix[i][j] = newWeight;
                    }
                }
            }
        }

        // 返回结果
        int minArrive = Integer.MAX_VALUE;
        int city = 0;
        for (int i = 0; i < matrix.length; i++) {
            int count = 0;
            for (int weight : matrix[i]) {
                count += weight > distanceThreshold ? 0 : 1;
            }

            if (count <= minArrive) {
                minArrive = count;
                city = i;
            }
        }

        return city;
    }
}
// @lc code=end
