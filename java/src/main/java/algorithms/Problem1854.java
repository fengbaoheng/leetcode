package algorithms;

/**
 * 1854.人口最多的年份
 */
public class Problem1854 {

    class Solution {
        private static final int BEGIN = 1950;
        private static final int END = 2050;
        private static final int N = END - BEGIN + 1;

        public int maximumPopulation(int[][] logs) {
            // 汇总所有年度人数的变化量
            int[] modify = new int[N];
            for (int[] log : logs) {
                int birth = log[0] - BEGIN;
                int death = log[1] - BEGIN;
                modify[birth]++;
                modify[death]--;
            }


            int maxYear = 0;
            int maxCount = 0;
            int count = 0;

            // 依次统计每年的总人口数
            for (int year = BEGIN; year <= END; year++) {
                count += modify[year - BEGIN];
                if (count > maxCount) {
                    maxCount = count;
                    maxYear = year;
                }
            }
            return maxYear;
        }
    }

}