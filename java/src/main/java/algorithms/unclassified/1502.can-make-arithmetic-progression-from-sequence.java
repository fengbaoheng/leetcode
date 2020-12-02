/*
 * @lc app=leetcode.cn id=1502 lang=java
 *
 * [1502] 判断能否形成等差数列
 */

// @lc code=start
import java.util.*;

class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        int n = arr.length;
        if (n <= 2) {
            return true;
        }

        Arrays.sort(arr);

        int diff = arr[1] - arr[0];
        for (int i = 2; i < n; i++) {
            if (diff != arr[i] - arr[i - 1]) {
                return false;
            }
        }

        return true;
    }
}
// @lc code=end

