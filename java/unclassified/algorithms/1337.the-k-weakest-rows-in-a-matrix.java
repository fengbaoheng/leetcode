/*
 * @lc app=leetcode.cn id=1337 lang=java
 *
 * [1337] 方阵中战斗力最弱的 K 行
 */

// @lc code=start
import java.util.*;
import java.util.stream.IntStream;


class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        return IntStream.range(0, mat.length)
                .mapToObj(i -> getRecord(i, mat[i]))
                .sorted(this.getComparator())
                .limit(k)
                .mapToInt(d -> d[0])
                .toArray();
    }

    // 获取行统计
    private int[] getRecord(int index, int[] row) {
        return new int[]{index, countSolider(row)};
    }

    // 统计士兵数量
    private int countSolider(int[] row) {
        int count = 0;
        for (int i : row) {
            count += i;
        }
        return count;
    }

    // 方阵比较, 先按士兵数量, 再按行索引
    private Comparator<int[]> getComparator() {
        return Comparator
                .comparingInt((int[] d) -> d[1])
                .thenComparingInt((int[] d) -> d[0]);
    }
}
// @lc code=end

