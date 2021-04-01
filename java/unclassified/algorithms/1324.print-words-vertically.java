/*
 * @lc app=leetcode.cn id=1324 lang=java
 *
 * [1324] 竖直打印单词
 */

// @lc code=start
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public List<String> printVertically(String s) {
        List<StringBuilder> words = new ArrayList<>();

        int col = 0;
        int row = 0;
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                // 单词分隔
                row = 0;
                col += 1;
            } else {
                // 单词长度超出最大长度, 新增一行
                if (row >= words.size()) {
                    // 空格补齐
                    char[] blank = new char[col];
                    Arrays.fill(blank, ' ');
                    words.add(new StringBuilder(String.valueOf(blank)));
                }

                // 添加字母
                StringBuilder word = words.get(row);
                while (word.length() < col) {
                    word.append(' ');
                }
                word.append(c);

                row++;
            }
        }

        return words.stream()
                .map(StringBuilder::toString)
                .collect(Collectors.toList());
    }
}
// @lc code=end

