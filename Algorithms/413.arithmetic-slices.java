/*
 * @lc app=leetcode.cn id=413 lang=java
 *
 * [413] 等差数列划分
 */

// @lc code=start
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int len = A.length;
        if (len < 3) {
            return 0;
        }

        // 总个数
        int sum = 0;

        // 以当前位置结尾的等差数列个数
        int slicesEndNumber = 0;
        for (int i = 2; i < len; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                // i-2, i-1, i是一个等差数列
                // 则以i结尾的等差数列就有slicesEndNumber + 1个
                slicesEndNumber += 1;
                sum += slicesEndNumber;
            } else {
                slicesEndNumber = 0;
            }
        }


        return sum;
    }
}
// @lc code=end

