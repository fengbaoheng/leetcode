/*
 * @lc app=leetcode.cn id=922 lang=java
 *
 * [922] 按奇偶排序数组 II
 */

class Solution {
    // 双指针 一个指向奇数索引 一个指向偶数索引
    public int[] sortArrayByParityII(int[] A) {
        int length = A.length;
        if (length == 0) {
            return A;
        }

        int[] result = new int[length];
        int evenIndex = 0;
        int oddIndex = 1;

        for (int i = 0; i < length; i++) {
            int num = A[i];
            if (num % 2 == 0) {
                result[evenIndex] = num;
                evenIndex += 2;
            } else {
                result[oddIndex] = num;
                oddIndex += 2;
            }
        }

        return result;
    }
}