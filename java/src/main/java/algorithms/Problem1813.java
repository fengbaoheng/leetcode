package algorithms;

/**
 * 1813.句子相似性 III
 */
public class Problem1813 {
    class Solution {
        public boolean areSentencesSimilar(String sentence1, String sentence2) {
            String[] words1 = sentence1.split(" ");
            String[] words2 = sentence2.split(" ");

            if (words1.length == words2.length) {
                return sentence1.equals(sentence2);
            }

            if (words1.length < words2.length) {
                return canInsert(words1, words2);
            } else {
                return canInsert(words2, words1);
            }


        }

        private boolean canInsert(String[] shortS, String[] longS) {
            int n = shortS.length;
            int m = longS.length;
            if (n == 0) {
                return true;
            }

            int i = 0;
            while (i < n && shortS[i].equals(longS[i])) {
                i++;
            }
            int r = n - i;
            for (int j = 0; j < r; j++) {
                if (!shortS[n - 1 - j].equals(longS[m - 1 - j])) {
                    return false;
                }
            }

            return true;
        }
    }


}