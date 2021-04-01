/*
 * @lc app=leetcode.cn id=424 lang=java
 *
 * [424] 替换后的最长重复字符
 */

// @lc code=start
import java.util.stream.IntStream;

class Solution {
    public int characterReplacement(String s, int k) {
        if (s.length() == 0) {
            return 0;
        }

        if (k >= s.length()) {
            return s.length();
        }

        return IntStream.range(0, 26)
                .map(i -> search(s, (char) ('A' + i), k))
                .max()
                .orElse(0);
    }

    // 滑动窗口寻找连续最长的字符target
    private int search(String str, char target, int maxModified) {
        int maxLen = 0;
        int left = 0;
        int modified = 0;

        // 不断向右扩展窗口
        for (int right = 0; right < str.length(); right++) {
            // 判断right处是否需要进行修改
            if (str.charAt(right) != target) {
                modified++;
            }

            // 查看当前区间[left,right]是否有效
            // 若无效则收缩左侧边缘，直至有效
            // 即符合modified <= maxModified的区间才是有效的
            while (modified > maxModified) {
                if (str.charAt(left) != target) {
                    modified--;
                }
                left++;
            }

            // 此时的[left,right]区间是有效的
            // 更新区间长度
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
// @lc code=end

