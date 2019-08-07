/*
 * @lc app=leetcode.cn id=941 lang=java
 *
 * [941] 有效的山脉数组
 */
class Solution {
    public boolean validMountainArray(int[] A) {
        int length = A.length;

        // 判断长度
        if (length < 3) {
            return false;
        }

        // 判断两端
        if (A[0] >= A[1] || A[length - 2] <= A[length - 1]) {
            return false;
        }

        boolean isIncreasing = true;

        for (int i = 1; i < length; i++) {
            int pre = A[i - 1];
            int cur = A[i];

            if (pre == cur) {
                return false;
            } else if (cur > pre) {
                // 上升过程
                if (!isIncreasing) {
                    return false;
                }
            } else {
                // 下降过程
                // 由上升转下降
                if(isIncreasing){
                    isIncreasing = false;
                }
            }
        }

        return true;
    }
}

