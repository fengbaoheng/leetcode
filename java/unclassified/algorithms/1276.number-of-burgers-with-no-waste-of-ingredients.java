/*
 * @lc app=leetcode.cn id=1276 lang=java
 *
 * [1276] 不浪费原料的汉堡制作方案
 */

// @lc code=start
import java.util.*;

class Solution {

    /**
     * 求二元一次方程
     * 4x+2y=t; x+y=c;
     * x=t/2-c; y=2c-t/2;
     *
     * @param tomatoSlices 番茄数量 t
     * @param cheeseSlices 奶酪数量 c
     * @return [x, y]
     */
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> result = new LinkedList<>();

        final int t = tomatoSlices, c = cheeseSlices;

        int x = t / 2 - c;
        int y = 2 * c - t / 2;

        if (t % 2 != 0 || x < 0 || y < 0) {
            return result;
        }

        result.add(x);
        result.add(y);

        return result;
    }
}
// @lc code=end

