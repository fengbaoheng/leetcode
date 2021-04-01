/*
 * @lc app=leetcode.cn id=1408 lang=java
 *
 * [1408] 数组中的字符串匹配
 */

// @lc code=start
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public List<String> stringMatching(String[] words) {
        String combined = String.join(" ", words);
        return Arrays.stream(words)
                .filter(word -> combined.indexOf(word) != combined.lastIndexOf(word))
                .collect(Collectors.toList());
    }
}
// @lc code=end

