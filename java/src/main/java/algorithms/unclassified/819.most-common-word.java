/*
 * @lc app=leetcode.cn id=819 lang=java
 *
 * [819] 最常见的单词
 */

// @lc code=start
import java.util.*;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        // 格式化规整字符串, 去除标点符号并转化为小写字符
        StringBuilder paragraphBuilder = new StringBuilder();
        for (char c : paragraph.toCharArray()) {
            if (c == '!' || c == '?' || c == '\'' || c == ',' || c == ';' || c == '.') {
                c = ' ';
            }

            if (c == ' ' && paragraphBuilder.charAt(paragraphBuilder.length() - 1) == ' ') {
                continue;
            }

            char lower = Character.toLowerCase(c);
            paragraphBuilder.append(lower);
        }

        // 依据空格拆分单词
        String[] words = paragraphBuilder.toString().split(" ");

        // 统计非禁用单词数目
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            if (bannedSet.contains(word)) {
                continue;
            }

            count.put(word, 1 + count.getOrDefault(word, 0));
        }


        // 计算最大单词数
        String most = null;
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            if (entry.getValue() > maxCount) {
                most = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        return most;
    }
}
// @lc code=end

