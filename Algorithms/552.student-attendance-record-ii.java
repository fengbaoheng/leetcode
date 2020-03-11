/*
 * @lc app=leetcode.cn id=552 lang=java
 *
 * [552] 学生出勤记录 II
 */

// @lc code=start
class Solution {
    private static final int MOD = 1000_000_007;

    public int checkRecord(int n) {
        if (n == 1) {
            return 3;
        }

        // 记录有无A,且连续多少个L
        // record[0][0]: 无A, 无L, record[1][1]: 有A, 连续1个L
        long[][] record = new long[][]{{1, 1, 0}, {1, 0, 0}};

        for (int i = 2; i <= n; i++) {
            long[][] nextRecord = new long[2][3];

            // 状态转移策略:
            // 1. 已经有1个A的不能再添加A
            // 2. 已经连续2个L的不能再添加L
            // 3. 添加P, A时都会中断L连续

            // A1L2 + P = A1L0
            // A1L1 + P = A1L0; A1L1 + L = A1L2
            // A1L0 + P = A1L0; A1L0 + L = A1L1;
            // A0L2 + P = A0L0; A0L2 + A = A1L0
            // A0L1 + P = A0L0; A0L1 + A = A1L0; A0L1 + L = A0L2;
            // A0L0 + P = A0L0; A0L0 + A = A1L0; A0L0 + L = A0L1;
            nextRecord[0][0] = getMod(record[0][2] + record[0][0] + record[0][1]);
            nextRecord[0][1] = record[0][0];
            nextRecord[0][2] = record[0][1];

            for (int r = 0; r < 2; r++) {
                for (int c = 0; c < 3; c++) {
                    nextRecord[1][0] += record[r][c];
                }
            }
            nextRecord[1][0] = getMod(nextRecord[1][0]);

            nextRecord[1][1] = record[1][0];

            nextRecord[1][2] = record[1][1];


            record = nextRecord;
        }

        long sum = record[0][0] + record[0][1] + record[0][2] + record[1][0] + record[1][1] + record[1][2];
        return (int) getMod(sum);
    }


    private long getMod(long num) {
        return num % MOD;
    }

}
// @lc code=end

