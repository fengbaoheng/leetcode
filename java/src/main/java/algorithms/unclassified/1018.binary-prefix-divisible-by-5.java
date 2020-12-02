/*
 * @lc app=leetcode.cn id=1018 lang=java
 *
 * [1018] 可被 5 整除的二进制前缀
 */

// @lc code=start
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> results = new LinkedList<>();

        int num = 0;
        for (int m : A) {
            num = (num * 2 + m) % 5;
            results.add(num == 0);
        }

        return results;
    }
}
// @lc code=end

