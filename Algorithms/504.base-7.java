/*
 * @lc app=leetcode.cn id=504 lang=java
 *
 * [504] 七进制数
 */

// @lc code=start
class Solution {

    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }

        // 正负数标志位
        boolean isNeg = num < 0;
        num = Math.abs(num);

        // 每次对7取余数 作为7进制的一位数字
        StringBuilder stringBuilder = new StringBuilder();
        while (num != 0) {
            int d = num % 7;
            num /= 7;
            stringBuilder.append(d);
        }
        
        // 反转顺序
        stringBuilder.reverse();

        // 添加负号
        if (isNeg) {
            stringBuilder.insert(0, '-');
        }

        return stringBuilder.toString();
    }
}
// @lc code=end

