/*
 * @lc app=leetcode.cn id=784 lang=java
 *
 * [784] 字母大小写全排列
 */

// @lc code=start
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public List<String> letterCasePermutation(String S) {
        // 记录所有结果字符串
        // 每个字符串还会不断追加字, 因此使用StringBuilder
        List<StringBuilder> results = new ArrayList<>();
        results.add(new StringBuilder());

        for (char c : S.toCharArray()) {
            if (Character.isLetter(c)) {
                // 字母
                int size = results.size();
                for (int i = 0; i < size; i++) {
                    // 复制一份, 并追加在最后
                    StringBuilder raw = results.get(i);
                    StringBuilder cloned = new StringBuilder(raw);
                    results.add(cloned);

                    // 原字符串添加小写字符, 复制字符串添加大写字符
                    raw.append(Character.toLowerCase(c));
                    cloned.append(Character.toUpperCase(c));
                }
            } else {
                // 数字直接追加
                results.forEach(builder -> builder.append(c));
            }
        }
        
        return results.stream().map(StringBuilder::toString).collect(Collectors.toList());
    }
}
// @lc code=end

