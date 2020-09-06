/*
 * @lc app=leetcode.cn id=966 lang=java
 *
 * [966] 元音拼写检查器
 */

// @lc code=start
import java.util.*;

class Solution {
    Set<String> wordSet;
    Map<String, String> lowerWordMap;
    Map<String, String> vowelWordMap;

    public String[] spellchecker(String[] wordlist, String[] queries) {
        wordSet = new HashSet<>(wordlist.length);
        lowerWordMap = new HashMap<>();
        vowelWordMap = new HashMap<>();


        for (String word : wordlist) {
            wordSet.add(word);

            String lowerWord = word.toLowerCase();
            lowerWordMap.putIfAbsent(lowerWord, word);

            String vowelWord = toVowelWord(word);
            vowelWordMap.putIfAbsent(vowelWord, word);
        }

        return Arrays.stream(queries).map(this::query).toArray(String[]::new);

    }

    // 将所有元音字母替换为下划线, 非元音字母修改为小写
    private String toVowelWord(String word) {
        StringBuilder builder = new StringBuilder();

        for (char c : word.toCharArray()) {
            builder.append(isVowel(c) ? '_' : Character.toLowerCase(c));
        }

        return builder.toString();
    }

    // 判断字符是否为元音
    private boolean isVowel(char c) {
        if (c >= 'a' && c <= 'z') {
            return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
        } else {
            return c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
        }
    }

    private String query(String word) {
        // 1. 查询是否有完全匹配的
        if (wordSet.contains(word)) {
            return word;
        }

        // 2. 转换为小写比对
        String lowerMatched = lowerWordMap.get(word.toLowerCase());
        if (lowerMatched != null) {
            return lowerMatched;
        }

        // 3. 去除元音后比对
        String vowelMatched = vowelWordMap.get(toVowelWord(word));
        if (vowelMatched != null) {
            return vowelMatched;
        }


        return "";
    }
}
// @lc code=end

