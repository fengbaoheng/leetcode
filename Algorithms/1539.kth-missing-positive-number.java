/*
 * @lc app=leetcode.cn id=1539 lang=java
 *
 * [1539] 第 k 个缺失的正整数
 */

// @lc code=start
class Solution {
    public int findKthPositive(int[] arr, int k) {
        // 指针指向下一个数
        int p = 0;
        int num = arr[p];

        // 遍历所有正整数
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if (i < num) {
                // 当前整数i是缺失的
                k--;
                if (k == 0) {
                    return i;
                }
            } else {
                // 指针后移到下个更大值
                p++;
                if (p < arr.length) {
                    num = arr[p];
                } else {
                    break;
                }
            }
        }

        return arr[arr.length - 1] + k;
    }
}
// @lc code=end

