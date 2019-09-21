/*
 * @lc app=leetcode.cn id=1170 lang=java
 *
 * [1170] 比较字符串最小字母出现频次
 */
class Solution {
    // 处理频繁查找问题
    // 注意word length <= 10, 可建立起缓存数组 O(1)查找
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] queriesCount = new int[queries.length];
        int[] wordsCount = new int[words.length];
        int[] accumulation = new int[12];

        for (int i = 0; i < queries.length; i++) {
            queriesCount[i] = f(queries[i]);
        }

        for (int i = 0; i < words.length; i++) {
            int count = f(words[i]);
            wordsCount[i] = count;
            accumulation[count]++;
        }

        // 累加 使得accumulation[count]等价于 有多少个f(word)大于等于count
        for (int i = 10; i >= 0; i--) {
            accumulation[i] += accumulation[i + 1];
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int count = queriesCount[i];
            result[i] = accumulation[count + 1];
        }

        return result;
    }

    // 注意利用题目条件 所有单词长度均小于等于10
    private int f(String word) {
        char minChar = word.charAt(0);
        int count = 0;

        for (char ch : word.toCharArray()) {
            if (ch == minChar) {
                count++;
            } else if (ch < minChar) {
                minChar = ch;
                count = 1;
            }
        }

        return count;
    }
}
