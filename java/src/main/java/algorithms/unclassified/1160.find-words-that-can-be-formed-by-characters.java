/*
 * @lc app=leetcode.cn id=1160 lang=java
 *
 * [1160] 拼写单词
 */
class Solution {
    private int[] charCount = new int[26];
    private int charLength;

    public int countCharacters(String[] words, String chars) {
        // 统计字符数
        for (char c : chars.toCharArray()) {
            charCount[c - 'a']++;
        }

        // 字符总个数
        charLength = chars.length();

        int sum = 0;
        for (String word : words) {
            sum += getCount(word);
        }
        return sum;

    }


    // 匹配单词 返回单词长度
    private int getCount(String word) {
        if (word.length() > charLength) {
            return 0;
        }

        int[] wordCount = new int[26];

        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (wordCount[i] >= charCount[i]) {
                return 0;
            } else {
                wordCount[i]++;
            }
        }

        return word.length();
    }
}

