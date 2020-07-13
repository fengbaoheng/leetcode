/*
 * @lc app=leetcode.cn id=1513 lang=java
 *
 * [1513] 仅含 1 的子串数
 */

// @lc code=start
import java.util.*;


class Solution {
    private static final int M = 1000000007;
    Map<Integer, Long> map;

    public int numSub(String s) {
        this.map = new HashMap<>();
        
        Map<Integer, Integer> lengthMap = countLength(s);
        lengthMap.forEach(this::accumulate);

        return getSumCount();
    }

    // 统计连续1的字符串长度及其出现的次数
    private Map<Integer, Integer> countLength(String s) {
        Map<Integer, Integer> map = new HashMap<>();

        int len = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                len++;
            } else if (len != 0) {
                map.merge(len, 1, Integer::sum);
                len = 0;
            }
        }

        if (len != 0) {
            map.merge(len, 1, Integer::sum);
        }

        return map;
    }

    // 累加结果
    private void accumulate(int c, int k) {
        if (c <= 0) {
            return;
        }

        long count = 1L;
        for (int i = c; i >= 1; i--) {
            long oldCount = map.getOrDefault(i, 0L);
            long newCount = (oldCount + count * k) % M;
            map.put(i, newCount);
            count++;
        }
    }

    
    // 求出总和
    private int getSumCount() {
        long result = 0L;
        for (Long value : map.values()) {
            result += value;
            result %= M;
        }

        return (int) result;
    }
}
// @lc code=end

