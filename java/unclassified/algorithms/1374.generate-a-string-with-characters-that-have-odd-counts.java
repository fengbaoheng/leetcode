/*
 * @lc app=leetcode.cn id=1374 lang=java
 *
 * [1374] 生成每种字符都是奇数个的字符串
 */

// @lc code=start
import java.util.*;

class Solution {
    public String generateTheString(int n) {
        char[] chars = new char[n];
        Arrays.fill(chars, 'a');

        if (n % 2 == 0) {
            chars[0] = 'b';
        }

        return new String(chars);
    }
}
// @lc code=end

