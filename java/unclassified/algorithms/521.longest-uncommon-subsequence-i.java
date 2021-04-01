/*
 * @lc app=leetcode.cn id=521 lang=java
 *
 * [521] 最长特殊序列 Ⅰ
 */

// @lc code=start
class Solution {
    public int findLUSlength(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();

        if (lenA == lenB) {
            return a.equals(b) ? -1 : lenA;
        } else {
            return Math.max(lenA, lenB);
        }
    }
}
// @lc code=end

