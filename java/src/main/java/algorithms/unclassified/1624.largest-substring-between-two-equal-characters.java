/*
 * @lc app=leetcode.cn id=1624 lang=java
 *
 * [1624] 两个相同字符之间的最长子字符串
 */

// @lc code=start
import java.util.Arrays;

class Solution {
    private static final int INVALID = -1;

    public int maxLengthBetweenEqualCharacters(String s) {
        int[] firstIndex = new int[26];
        Arrays.fill(firstIndex, INVALID);

        int[] lastIndex = new int[26];
        Arrays.fill(lastIndex, INVALID);

        int n = s.length();
        for (int i = 0; i < n; i++) {
            int index = (s.charAt(i) - 'a');

            if (firstIndex[index] == INVALID) {
                // 第一次出现
                firstIndex[index] = i;
            } else {
                // 非第一次出现，更新最后出现位置
                lastIndex[index] = i;
            }
        }

        int maxLength = -1;

        for (int i = 0; i < 26; i++) {
            int first = firstIndex[i];
            if (first == INVALID) {
                // 一次都未出现过
                continue;
            }

            int last = lastIndex[i];
            if (last == INVALID) {
                // 只出现了一次
                continue;
            }

            maxLength = Math.max(maxLength, last - first - 1);
        }

        return maxLength;
    }
}
// @lc code=end

