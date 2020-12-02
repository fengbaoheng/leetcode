
/*
 * @lc app=leetcode.cn id=1002 lang=java
 *
 * [1002] 查找常用字符
 */
import java.util.*;

class Solution {
    private Set<Character> set = new HashSet<>(26, 1);
    private int[] count = new int[26];

    public List<String> commonChars(String[] A) {

        // 初始化A
        String firstWord = A[0];
        Map<Character, Integer> firstCount = getWordCount(firstWord, false);
        addCount(firstCount, false);

        for (int i = 1; i < A.length; i++) {
            addCount(getWordCount(A[i], true), true);
        }

        return toStringList();
    }

    // 统计单词中各单词出现的次数
    private Map<Character, Integer> getWordCount(String word, boolean isFilter) {
        // 统计字符出现次数
        Map<Character, Integer> wordCount = new HashMap<>();

        for (char c : word.toCharArray()) {
            if (isFilter && !set.contains(c)) {
                continue;
            }

            wordCount.put(c, wordCount.getOrDefault(c, 0) + 1);
        }

        return wordCount;
    }

    // 将单词的统计结果合并汇总
    private void addCount(Map<Character, Integer> wordCount, boolean isOverride) {
        if (isOverride) {
            Iterator<Character> iterator = set.iterator();
            while (iterator.hasNext()) {
                Character key = iterator.next();
                int index = key - 'a';

                // 字符没有出现, 清除
                if (!wordCount.containsKey(key)) {
                    iterator.remove();
                    count[index] = 0;
                } else {
                    // 统计最小出现次数
                    count[index] = Math.min(count[index], wordCount.get(key));
                }
            }
        } else {
            for (Character key : wordCount.keySet()) {
                int index = key - 'a';
                int value = wordCount.get(key);

                count[index] = value;
                set.add(key);
            }
        }
    }

    // 格式输出
    private List<String> toStringList() {
        List<String> result = new ArrayList<>();

        for (Character key : set) {
            String str = key.toString();
            int index = key - 'a';
            int value = count[index];

            for (int i = 0; i < value; i++) {
                result.add(str);
            }
        }

        return result;
    }
}
