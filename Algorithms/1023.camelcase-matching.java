/*
 * @lc app=leetcode.cn id=1023 lang=java
 *
 * [1023] 驼峰式匹配
 */

// @lc code=start
import java.util.*;
import java.util.stream.Collectors;


class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        return Arrays.stream(queries)
                .map(query -> isMatch(query, pattern))
                .collect(Collectors.toList());
    }

    private boolean isMatch(String query, String pattern) {
        StringBuilder builder = new StringBuilder();
        for (char c : query.toCharArray()) {
            boolean notEquals = builder.length() == pattern.length() || c != pattern.charAt(builder.length());

            if (!notEquals) {
                builder.append(c);
            } else if (Character.isUpperCase(c)) {
                // 小写不匹配可以跳过，不添加
                // 大写必须匹配
                return false;
            }
        }

        return builder.length() == pattern.length();
    }
}
// @lc code=end

