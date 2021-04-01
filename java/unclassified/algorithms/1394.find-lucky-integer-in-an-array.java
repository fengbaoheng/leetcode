/*
 * @lc app=leetcode.cn id=1394 lang=java
 *
 * [1394] 找出数组中的幸运数
 */

// @lc code=start
class Solution {
    public int findLucky(int[] arr) {
        int[] counts = new int[501];

        for (int num : arr) {
            counts[num]++;
        }

        int result  = -1;

        for (int i = 1; i <= 500; i++) {
            if(counts[i] == i){
                result = i;
            }
        }

        return result;
    }
}
// @lc code=end
