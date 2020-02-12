/*
 * @lc app=leetcode.cn id=1342 lang=java
 *
 * [1342] 将数字变成 0 的操作次数
 */

// @lc code=start
class Solution {
    public int numberOfSteps(int num) {
        if (num == 0) {
            return 0;
        }

        int count = 0;
        while (true) {
            count++;
            if (num == 1) {
                break;
            }

            // 奇数额外需要一次操作
            if (num % 2 == 1) {
                count++;
            }

            num /= 2;
        }

        return count;
    }
}
// @lc code=end

