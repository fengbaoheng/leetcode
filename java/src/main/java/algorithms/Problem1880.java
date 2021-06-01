package algorithms;

/**
 * 1880.检查某单词是否等于两单词之和
 */
public class Problem1880 {

    class Solution {
        public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
            return toNumber(firstWord) + toNumber(secondWord) == toNumber(targetWord);
        }

        private int toNumber(String word) {
            int num = 0;
            for (char ch : word.toCharArray()) {
                num = num * 10 + ch - 'a';
            }
            return num;
        }
    }


}