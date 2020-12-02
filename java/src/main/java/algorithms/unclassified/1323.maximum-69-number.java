/*
 * @lc app=leetcode.cn id=1323 lang=java
 *
 * [1323] 6 和 9 组成的最大数字
 */

// @lc code=start
class Solution {
    public int maximum69Number (int num) {
        String str = Integer.valueOf(num).toString();
        str = str.replaceFirst("6","9");
        num = Integer.parseInt(str);
        return num;
    }
}
// @lc code=end

