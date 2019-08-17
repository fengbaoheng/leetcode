/*
 * @lc app=leetcode.cn id=884 lang=java
 *
 * [884] 两句话中的不常见单词
 */
import java.util.*;


class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        Set<String> commonWord = new HashSet<>();
        Set<String> totalWord = new HashSet<>();

        // 重复的单词添加到commonWord中
        // 所有单词添加到totalWord中
        for (String word:A.split(" ")){
            if(!totalWord.add(word)){
                commonWord.add(word);
            }
        }

        for (String word:B.split(" ")){
            if(!totalWord.add(word)){
                commonWord.add(word);
            }
        }

        // 差集即只出现一次的单词
        totalWord.removeAll(commonWord);

        return totalWord.toArray(new String[0]);

    }
}
