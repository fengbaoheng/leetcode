/*
 * @lc app=leetcode.cn id=1299 lang=java
 *
 * [1299] 将每个元素替换为右侧最大元素
 */

// @lc code=start
class Solution {
    public int[] replaceElements(int[] arr) {
        int max = -1;

        for (int i = arr.length - 1; i >= 0; i--) {
            int tmp = arr[i];
            arr[i] = max;
            max = Math.max(max, tmp);
        }

        return arr;
    }
}
// @lc code=end

