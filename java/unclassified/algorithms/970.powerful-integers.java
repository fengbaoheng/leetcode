/*
 * @lc app=leetcode.cn id=970 lang=java
 *
 * [970] 强整数
 */

// @lc code=start
import java.util.*;

class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        if (bound == 0) {
            return List.of();
        }

        List<Integer> xExponent = getExponent(x, bound);
        List<Integer> yExponent = getExponent(y, bound);

        Set<Integer> results = new HashSet<>();
        for (Integer i : xExponent) {
            for (Integer j : yExponent) {
                int sum = i + j;
                if (sum > bound) {
                    break;
                }
                results.add(sum);
            }
        }

        return new LinkedList<>(results);
    }

    /**
     * 给定底数,计算不超过上限的所有指数值
     * @param base 底数
     * @param bound 上限
     * @return 所有符合要求的值
     */
    private List<Integer> getExponent(int base, int bound) {
        if (base == 1) {
            return List.of(1);
        }

        List<Integer> results = new LinkedList<>();

        int num = 1;
        while (num < bound) {
            results.add(num);
            num *= base;
        }

        return results;
    }
}
// @lc code=end

