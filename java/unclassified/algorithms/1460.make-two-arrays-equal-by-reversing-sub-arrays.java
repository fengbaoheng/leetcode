/*
 * @lc app=leetcode.cn id=1460 lang=java
 *
 * [1460] 通过翻转子数组使两个数组相等
 */

// @lc code=start
class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] count = new int[1001];

        for (int num : target) {
            count[num]++;
        }

        for (int num : arr) {
            if (count[num] <= 0) {
                return false;
            }
            count[num]--;
        }

        return true;
    }
}
// @lc code=end

