/*
 * @lc app=leetcode.cn id=1619 lang=java
 *
 * [1619] 删除某些元素后的数组均值
 */

// @lc code=start
import java.util.Arrays;

class Solution {
    public double trimMean(int[] arr) {
        int n = arr.length;
        int m = n / 20;

        Arrays.sort(arr);
        int sum = 0;
        for (int i = m; i < n - m; i++) {
            sum += arr[i];
        }

        return 1.0 * sum / (n - m - m);
    }
}
// @lc code=end

