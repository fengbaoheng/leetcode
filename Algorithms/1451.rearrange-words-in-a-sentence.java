/*
 * @lc app=leetcode.cn id=1451 lang=java
 *
 * [1451] 重新排列句子中的单词
 */

// @lc code=start
import java.util.*;


class Solution {
    public String arrangeWords(String text) {
        String[] words = text.split(" ");
        words[0] = words[0].toLowerCase();

        Map<Integer, List<String>> count = new HashMap<>(words.length);

        for (String word : words) {
            int len = word.length();
            count.putIfAbsent(len, new LinkedList<>());
            count.get(len).add(word);
        }

        List<String> list = new ArrayList<>(words.length);
        count.keySet().stream().sorted().map(count::get).forEach(list::addAll);

        list.set(0, toFirstWord(list.get(0)));

        return String.join(" ", list);
    }

    private String toFirstWord(String word) {
        StringBuilder sb = new StringBuilder();
        sb.append(Character.toUpperCase(word.charAt(0)));
        for (int i = 1; i < word.length(); i++) {
            sb.append(word.charAt(i));
        }
        return sb.toString();
    }
}
// @lc code=end

