/*
 * @lc app=leetcode.cn id=1016 lang=java
 *
 * [1016] 子串能表示从 1 到 N 数字的二进制串
 */

// @lc code=start
import java.util.stream.IntStream;

class Solution {
    public boolean queryString(String S, int N) {
        return IntStream
                .rangeClosed(1, N)
                .mapToObj(Integer::toBinaryString)
                .allMatch(S::contains);
    }
}
// @lc code=end

