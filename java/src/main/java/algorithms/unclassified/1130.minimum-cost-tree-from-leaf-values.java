/*
 * @lc app=leetcode.cn id=1130 lang=java
 *
 * [1130] 叶值的最小代价生成树
 */

// @lc code=start
class Solution {
    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;

        // 记录区间内叶子节点的最大值
        int[][] maxLeaf = new int[n][n];
        for (int r = 0; r < n; r++) {
            int max = arr[r];
            for (int c = r; c < n; c++) {
                max = Math.max(max, arr[c]);
                maxLeaf[r][c] = max;
            }
        }


        int[][] minSum = new int[n][n];
        // 斜向遍历
        for (int k = 1; k < n; k++) {
            for (int r = 0; r < n; r++) {
                int c = r + k;
                if (c >= n) {
                    break;
                }

                minSum[r][c] = Integer.MAX_VALUE;
                for (int i = r; i < c; i++) {
                    // 拆分为两个子树[r,i] [i+1, c]
                    // 分别找到两个子树的最大叶子节点的乘积、左子树非叶子节点累计和，右子树非叶子节点累计和
                    int newSum = maxLeaf[r][i] * maxLeaf[i + 1][c] + minSum[r][i] + minSum[i + 1][c];
                    minSum[r][c] = Math.min(minSum[r][c], newSum);
                }
            }
        }


        return minSum[0][n - 1];
    }
}
// @lc code=end

