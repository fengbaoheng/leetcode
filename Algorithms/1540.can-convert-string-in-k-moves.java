/*
 * @lc app=leetcode.cn id=1540 lang=java
 *
 * [1540] K 次操作转变字符串
 */

// @lc code=start
import java.util.Arrays;

class Solution {
    int[] counts = new int[26];

    public boolean canConvertString(String s, String t, int k) {
        if (s.length() != t.length()) {
            return false;
        }

        if (s.equals(t)) {
            return true;
        }

        Arrays.fill(counts, 0);

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            if (charS != charT) {
                // 原始转换次数
                int c = getConvertCount(charS, charT);

                // 实际需要的转换次数
                if (counts[c] != 0) {
                    counts[c] += 26;
                } else {
                    counts[c] = c;
                }

                if (counts[c] > k) {
                    return false;
                }
            }
        }

        return true;
    }

    private int getConvertCount(char s, char t) {
        return ((t - 'a') - (s - 'a') + 26) % 26;
    }
}
// @lc code=end

