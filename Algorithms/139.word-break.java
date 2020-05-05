/*
 * @lc app=leetcode.cn id=139 lang=java
 *
 * [139] 单词拆分
 */

// @lc code=start
import java.util.*;


class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len];

        // 在每个位置都遍历所有单词
        for (int i = 0; i < s.length(); i++) {
            for (String word : wordDict) {
                int start = i - word.length() + 1;

                // 该单词是否有资格匹配
                if (start < 0 || (start != 0 && !dp[start - 1])) {
                    continue;
                }

                // 匹配单词
                boolean isMatch = true;
                for (int j = 0; j < word.length(); j++) {
                    if (s.charAt(start + j) != word.charAt(j)) {
                        isMatch = false;
                        break;
                    }
                }

                if (isMatch) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[len - 1];
    }
}
// @lc code=end

