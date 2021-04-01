/*
 * @lc app=leetcode.cn id=1404 lang=java
 *
 * [1404] 将二进制表示减到 1 的步骤数
 */

// @lc code=start
class Solution {
    public int numSteps(String s) {
        int result = 0;
        int carry = 0;
        char[] arr = s.toCharArray();
        for (int i = arr.length - 1; i >= 0; i--) {
            int num = (arr[i] - '0') + carry;

            // 最后1位
            if (i == 0) {
                result += num == 1 ? 0 : 1;
                break;
            }

            // 判断奇数偶数
            if (num == 1) {
                num += 1;
                result += 2;
            } else {
                result += 1;
            }

            // 处理进位
            if (num == 2) {
                carry = 1;
            }
        }

        return result;
    }
}
// @lc code=end

