/*
 * @lc app=leetcode.cn id=1340 lang=java
 *
 * [1340] 跳跃游戏 V
 */

// @lc code=start
class Solution {
    private int[] arr;
    private int n, d;
    private Integer[] jumps;

    public int maxJumps(int[] arr, int d) {
        this.arr = arr;
        this.n = arr.length;
        this.d = d;
        this.jumps = new Integer[n];

        int maxJumps = 0;
        for (int i = 0; i < n; i++) {
            if (jumps[i] == null) {
                jumps[i] = getJumps(i);
            }
            maxJumps = Math.max(maxJumps, jumps[i]);
        }
        return maxJumps;
    }

    // 递归查找
    private int getJumps(int index) {
        if (jumps[index] != null) {
            return jumps[index];
        }

        int max = 1;
        int val = arr[index];

        // 左跳
        int left = Math.max(0, index - d);
        for (int i = index - 1; i >= left && arr[i] < val; i--) {
            max = Math.max(max, 1 + getJumps(i));
        }

        // 右跳
        int right = Math.min(n - 1, index + d);
        for (int i = index + 1; i <= right && arr[i] < val; i++) {
            max = Math.max(max, 1 + getJumps(i));
        }

        jumps[index] = max;
        return max;
    }
}
// @lc code=end

