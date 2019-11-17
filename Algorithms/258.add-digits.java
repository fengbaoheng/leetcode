/*
 * @lc app=leetcode.cn id=258 lang=java
 *
 * [258] 各位相加
 */

// @lc code=start
class Solution {
    // 看做是特殊的9进制
    // 不带进位 即 永远都是1位数, 小于等于9
    // 除了0以外, 不会出现0, 即0,1,,,9,1,2,,,9,1,2
    // 或者说9就是0
    public int addDigits(int num) {
        if (num <= 9) {
            return num;
        } else {
            num %= 9;
            return num == 0 ? 9 : num;
        }
    }
}
// @lc code=end

