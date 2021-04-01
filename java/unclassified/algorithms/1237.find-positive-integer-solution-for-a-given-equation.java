/*
 * @lc app=leetcode.cn id=1237 lang=java
 *
 * [1237] 找出给定方程的正整数解
 */

// @lc code=start
/*
 * // This is the custom function interface.
 * // You should not implement it, or speculate about its implementation
 * class CustomFunction {
 *     // Returns f(x, y) for any given positive integers x and y.
 *     // Note that f(x, y) is increasing with respect to both x and y.
 *     // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
 *     public int f(int x, int y);
 * };
 */
import java.util.*;

class Solution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> resultList = new LinkedList<>();

        // 利用单调特性, 使用双指针从两侧逼近
        int p = 1, q = 1000;
        while (p <= 1000 && q >= 1) {
            int value = customfunction.f(p, q);
            if (value > z) {
                q--;
            } else if (value < z) {
                p++;
            } else {
                List<Integer> result = new LinkedList<>();
                result.add(p);
                result.add(q);
                resultList.add(result);
                p++;
            }
        }

        return resultList;
    }
}
// @lc code=end

