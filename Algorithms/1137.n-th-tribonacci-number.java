/*
 * @lc app=leetcode.cn id=1137 lang=java
 *
 * [1137] 第N个泰波那契数
 */

class Solution {
    // 使用迭代代替递归
    // 注意边界条件
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n <= 2) {
            return 1;
        }

        int[] t = new int[n + 1];
        t[0] = 0;
        t[1] = 1;
        t[2] = 1;

        for (int i = 3; i < n + 1; i++) {
            t[i] = t[i-1] + t[i-2] + t[i-3];
        }

        return t[n];
    }
}

