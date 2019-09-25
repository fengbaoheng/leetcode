/*
 * @lc app=leetcode.cn id=1128 lang=java
 *
 * [1128] 等价多米诺骨牌对的数量
 */
class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        // 记录牌的数量 长度介于1~9
        int[][] count = new int[10][10];

        for (int[] dominoe : dominoes) {
            int i = dominoe[0];
            int j = dominoe[1];

            if (i <= j) {
                count[i][j]++;
            } else {
                count[j][i]++;
            }
        }

        int num = 0;
        for (int i = 1; i < 10; i++) {
            for (int j = i; j < 10; j++) {
                int c = count[i][j];
                if (c >= 2) {
                    // 排列组合 从count中抽取两个数
                    num += c * (c - 1) / 2;
                }
            }
        }

        return num;
    }
}

