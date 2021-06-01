package algorithms;

/**
 * 1859.将句子排序
 */
public class Problem1859 {

    class Solution {
        public String sortSentence(String s) {
            String[] words = s.split(" ");
            int n = words.length;
            String[] strings = new String[n];

            for (String word : words) {
                int m = word.length();
                int i = word.charAt(m - 1) - '0';
                strings[i - 1] = word.substring(0, m - 1);
            }

            return String.join(" ", strings);
        }
    }

}