/*
 * @lc app=leetcode.cn id=1048 lang=java
 *
 * [1048] 最长字符串链
 */

// @lc code=start
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public int longestStrChain(String[] words) {
        // 按长度从大到小排序
        List<String> list = Arrays.stream(words)
                .sorted(Comparator.comparingInt(String::length).reversed())
                .collect(Collectors.toList());

        int[] dp = new int[words.length];

        for (int i = 0; i < list.size(); i++) {
            // 当前单词的最短链长是1，即只有他自己
            String strLong = list.get(i);
            dp[i] = Math.max(dp[i], 1);

            // 向后方寻找衔接链
            for (int j = i + 1; j < list.size(); j++) {
                String strShort = list.get(j);
                int diffLen = strLong.length() - strShort.length();
                if (diffLen == 0) {
                    // 长度相同继续向后查找
                    continue;
                } else if (diffLen > 1) {
                    // 大于1不用继续向后查找
                    break;
                }

                // 判断长度相差1的两个单词是否成链
                if (isChain(strLong, strShort)) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
        }

        return IntStream.of(dp).max().orElse(0);
    }
    
    private boolean isChain(String strLong, String strShort) {
        int diff = 0, p = 0, q = 0;

        while (diff <= 1 && p < strShort.length() && q < strLong.length()) {
            char c1 = strShort.charAt(p);
            char c2 = strLong.charAt(q);

            if (c1 == c2) {
                p++;
            } else {
                diff++;
            }
            q++;
        }

        return diff <= 1;
    }
}
// @lc code=end

