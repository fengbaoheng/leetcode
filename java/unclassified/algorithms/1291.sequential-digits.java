/*
 * @lc app=leetcode.cn id=1291 lang=java
 *
 * [1291] 顺次数
 */

// @lc code=start
import java.util.*;

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> results = new LinkedList<>();

        for (int len = getLength(low); len <= getLength(high); len++) {
            results.addAll(getRangeNum(len, low, high));
        }

        return results;
    }

    /**
     * 计算数字的位数
     *
     * @param num 整数
     * @return 位数
     */
    private int getLength(int num) {
        int len = 0;

        while (num != 0) {
            len++;
            num /= 10;
        }

        return len;
    }

    /**
     * 计算指定长度的顺次数
     *
     * @param len  数字长度
     * @param low  最小数字
     * @param high 最大数字
     * @return 符合要求的所有数字
     */
    private List<Integer> getRangeNum(int len, int low, int high) {
        List<Integer> results = new LinkedList<>();

        // 长度无法组合数字
        if (len > 9 || len <= 0) {
            return results;
        }

        // 最大起始数字
        int start = 1;
        int maxStart = 10 - len;

        // 对每种起始数字依次组合
        for (int s = start; s <= maxStart; s++) {
            int num = getNum(s, len);
            if (num >= low && num <= high) {
                results.add(num);
            }
        }

        return results;
    }

    /**
     * 生成数字
     *
     * @param start 首尾数字
     * @param len   数字长度
     * @return 结果
     */
    private int getNum(int start, int len) {
        int next = start;
        int num = 0;

        do {
            num = num * 10 + next;
            next++;
            len--;
        } while (len > 0);

        return num;
    }
}
// @lc code=end

