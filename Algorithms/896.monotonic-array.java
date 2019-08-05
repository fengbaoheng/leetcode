/*
 * @lc app=leetcode.cn id=896 lang=java
 *
 * [896] 单调数列
 */
class Solution {
    public boolean isMonotonic(int[] A) {
        int length = A.length;
        if (length <= 1) {
            return true;
        }

        // flag = -1 单调减
        // flag = 1 单调增
        // flag = 0 未能判断单调性
        int flag = 0;

        for (int i = 1; i < length; i++) {
            int cur = A[i] - A[i - 1];
            // cur = 0 则跳过
            if (cur != 0) {
                if (flag == 0) {
                    // 确定单调性
                    flag = cur;
                } else if ((flag > 0) != (cur > 0)) {
                    // 当前单调性不一致
                    return false;
                }
            }
        }

        return true;
    }
}

