/*
 * @lc app=leetcode.cn id=1346 lang=java
 *
 * [1346] 检查整数及其两倍数是否存在
 */

// @lc code=start
import java.util.*;

class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();

        // 单独考虑0的情况
        int zeroCount = 0;

        for (int num : arr) {
            if (num == 0) {
                zeroCount++;
                if (zeroCount == 2) {
                    return true;
                }
            }

            // 检查2*num是否存在
            if (set.contains(2 * num)) {
                return true;
            }

            // 如果是偶数, 则检查0.5 * num是否存在
            if (num % 2 == 0 && set.contains(num / 2)) {
                return true;
            }

            set.add(num);
        }

        return false;
    }
}
// @lc code=end

