/*
 * @lc app=leetcode.cn id=861 lang=java
 *
 * [861] 翻转矩阵后的得分
 */
class Solution {
    public int matrixScore(int[][] A) {
        int rows = A.length;
        int cols = A[0].length;

        // 第一列通过 翻转行保持全为1
        for (int r = 0; r < rows; r++) {
            if (A[r][0] == 0) {
                for (int c = 0; c < cols; c++) {
                    A[r][c] = (A[r][c] + 1) % 2;
                }
            }
        }

        // 之后的每一列不再翻转行, 只翻转列
        // 保持每一列1的个数多余0的个数
        for (int c = 1; c < cols; c++) {
            int countOne = 0;
            for (int r = 0; r < rows; r++) {
                if (A[r][c] == 1) {
                    countOne++;
                }
            }

            if (countOne < (rows / 2.0)) {
                for (int r = 0; r < rows; r++) {
                    A[r][c] = (A[r][c] + 1) % 2;
                }
            }
        }
        // 输出
        return getBinNum(A);
    }

    // 转二进制数组并求和
    private int getBinNum(int[][] A) {
        int sum = 0;

        for (int[] row : A) {
            StringBuilder sb = new StringBuilder();

            for (int c : row) {
                sb.append(c);
            }

            sum += Integer.parseInt(sb.toString(), 2);
        }

        return sum;
    }
}

