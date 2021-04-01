/*
 * @lc app=leetcode.cn id=1578 lang=java
 *
 * [1578] 避免重复字母的最小删除成本
 */

// @lc code=start
class Solution {
    private static final char NONE = ' ';

    public int minCost(String s, int[] cost) {
        // 记录上次出现的字符
        char lastChar = NONE;
        int maxCost = 0;
        int sumCost = 0;
        boolean repeated = false;

        int totalCost = 0;
        for (int i = 0; i < cost.length; i++) {
            char curChar = s.charAt(i);
            int curCost = cost[i];

            if (curChar == lastChar) {
                // 发生重复，则记录所有重复字符的累加代价和最大代价
                repeated = true;
                maxCost = Math.max(maxCost, curCost);
                sumCost += curCost;
            } else {
                // 累加上次的值
                // 所有重复的字符只能保留一个
                // 则保留删除代价最大的那个字符不删除，而删除其他的字符
                if (repeated) {
                    totalCost += sumCost - maxCost;
                }

                // 刷新变量的值
                repeated = false;
                lastChar = curChar;
                maxCost = curCost;
                sumCost = curCost;
            }
        }

        // 处理末尾数字
        if (repeated) {
            totalCost += sumCost - maxCost;
        }

        return totalCost;
    }
}
// @lc code=end

