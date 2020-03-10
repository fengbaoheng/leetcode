/*
 * @lc app=leetcode.cn id=1370 lang=java
 *
 * [1370] 上升下降字符串
 */

// @lc code=start
class Solution {
    public String sortString(String s) {
        // 统计出现次数
        int[] counts = new int[26];
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }

        StringBuilder result = new StringBuilder();

        boolean isAsc = true;
        while (result.length() != s.length()) {
            StringBuilder str = new StringBuilder();

            for (int i = 0; i < counts.length; i++) {
                if (counts[i] != 0) {
                    counts[i]--;
                    str.append((char) ('a' + i));
                }
            }
            result.append(isAsc ?  str : str.reverse());
            isAsc = !isAsc;
        }

        return result.toString();
    }
}
// @lc code=end

