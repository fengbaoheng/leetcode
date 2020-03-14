import java.math.BigDecimal;
import java.math.BigInteger;

/*
 * @lc app=leetcode.cn id=1093 lang=java
 *
 * [1093] 大样本统计
 */

// @lc code=start
class Solution {
    private int[] count;

    public double[] sampleStats(int[] count) {
        this.count = count;
        int max = -1;
        int min = -1;

        int mode = 0;
        int maxCounts = 0;

        long numCounts = 0;
        long sum = 0;

        for (int num = 0; num <= 255; num++) {
            int counts = count[num];

            if (counts == 0) {
                continue;
            }

            // 最新值即最大值
            max = num;

            // 若还没遇到最小值, 即为最小值
            if (min == -1) {
                min = num;
            }

            // 次数最多即众数
            if (counts > maxCounts) {
                mode = num;
                maxCounts = counts;
            }

            numCounts += counts;
            sum += num * counts;
        }

        // 平均数
        double average = 1.0 * sum / numCounts;

        // 中位数
        double median = 0;
        long mid = numCounts / 2;
        if (numCounts % 2 == 0) {
            median = (getNum(mid) + getNum(mid - 1)) / 2.0;
        } else {
            median = getNum(mid);
        }
        return new double[] { min, max, average, median, mode };
    }

    private int getNum(long index) {
        index++;
        for (int num = 0; num <= 255; num++) {
            int counts = count[num];
            if (counts >= index) {
                return num;
            }
            index -= counts;
        }
        return -1;
    }
}
// @lc code=end
