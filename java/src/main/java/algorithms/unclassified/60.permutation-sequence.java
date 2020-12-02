import java.util.*;

/*
 * @lc app=leetcode.cn id=60 lang=java
 *
 * [60] 第k个排列
 */

// @lc code=start
class Solution {
    public String getPermutation(int n, int k) {

        // 所有可选数字从小到大排序
        List<Integer> nums = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        StringBuilder stringBuilder = new StringBuilder();
        
        for (int i = 1; i <= n; i++) {
            int solutions = getFactorial(n - i);
            int index = (k - 1) / solutions;
            k -= index * solutions;

            int num = nums.remove(index);
            stringBuilder.append(num);
        }

        return stringBuilder.toString();

    }

    /**
     * 
     * @param n
     * @return 阶乘
     */
    private int getFactorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }

        return result;
    }
}
// @lc code=end
