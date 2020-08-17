/*
 * @lc app=leetcode.cn id=1550 lang=java
 *
 * [1550] 存在连续三个奇数的数组
 */

// @lc code=start
class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;

        for (int num : arr) {
            if (num % 2 == 0) {
                count = 0;
            } else {
                count++;
                if (count >= 3) {
                    return true;
                }
            }
        }


        return false;
    }
}
// @lc code=end

