/*
 * @lc app=leetcode.cn id=1431 lang=java
 *
 * [1431] 拥有最多糖果的孩子
 */

// @lc code=start
import java.util.*;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Arrays.stream(candies).max().orElse(0);

        List<Boolean> result = new LinkedList<>();
        for (int candy : candies) {
            result.add(candy + extraCandies >= max);
        }

        return result;
    }
}
// @lc code=end

