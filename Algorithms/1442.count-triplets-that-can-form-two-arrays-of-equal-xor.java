/*
 * @lc app=leetcode.cn id=1442 lang=java
 *
 * [1442] 形成两个异或相等数组的三元组数目
 */

// @lc code=start
import java.util.Arrays;

class Solution {
    public int countTriplets(int[] arr) {
        int len = arr.length;
        int count = 0;

        int[] x = Arrays.copyOf(arr, len);
        for (int i = 1; i < x.length; i++) {
            x[i] = x[i - 1] ^ x[i];
        }


        for (int i = 0; i < len - 1; i++) {
            for (int k = i + 1; k < len; k++) {
                int xor = i == 0 ? x[k] : x[i - 1] ^ x[k];
                if (xor == 0) {
                    count += k - i;
                }
            }
        }

        return count;
    }
}
// @lc code=end

