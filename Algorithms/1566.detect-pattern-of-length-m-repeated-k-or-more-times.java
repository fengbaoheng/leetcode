/*
 * @lc app=leetcode.cn id=1566 lang=java
 *
 * [1566] 重复至少 K 次且长度为 M 的模式
 */

// @lc code=start
class Solution {
    public boolean containsPattern(int[] arr, int m, int k) {
        // 记录重复次数
        int[] counts = new int[arr.length];

        for (int i = arr.length - m; i >= 0; i--) {
            // 如果发生了重复则累加重复次数,否则就自己只出现一次
            if (isSame(arr, i, i + m, m)) {
                counts[i] = 1 + counts[i + m];
            } else {
                counts[i] = 1;
            }

            // 检查是否达标
            if (counts[i] >= k) {
                return true;
            }

        }

        return false;
    }

    /**
     * 检测[i, i+m]是否与[j, j+m]相同
     */
    private boolean isSame(int[] arr, int i, int j, int m) {
        if (j + m > arr.length) {
            return false;
        }

        for (int k = 0; k < m; k++) {
            if (arr[i + k] != arr[j + k]) {
                return false;
            }
        }

        return true;
    }
}
// @lc code=end

