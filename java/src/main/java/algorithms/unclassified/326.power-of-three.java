
/*
 * @lc app=leetcode.cn id=326 lang=java
 *
 * [326] 3的幂
 */

// @lc code=start
class Solution {
    public boolean isPowerOfThree(int n) {
        String text = Integer.toString(n, 3);
        int sum = 0;
        for (char c : text.toCharArray()) {
            sum += c - '0';
        }
        return sum == 1;
    }
}
// @lc code=end
