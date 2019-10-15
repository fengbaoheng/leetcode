/*
 * @lc app=leetcode.cn id=748 lang=java
 *
 * [748] 最短完整词
 */

// @lc code=start
class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] license = new int[26];
        for (char c : licensePlate.toCharArray()) {
            if (Character.isLetter(c)) {
                license[Character.toLowerCase(c) - 'a']++;
            }
        }

        String minWord = "";
        for (String word : words) {
            int[] count = new int[26];
            for (char c : word.toCharArray()) {
                count[c - 'a']++;
            }

            boolean isValid = true;
            for (int i = 0; i < 26; i++) {
                if (count[i] < license[i]) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                if (minWord.length() == 0) {
                    minWord = word;
                } else if (minWord.length() != word.length()) {
                    minWord = minWord.length() < word.length() ? minWord : word;
                }
            }
        }

        return minWord;
    }
}
// @lc code=end

