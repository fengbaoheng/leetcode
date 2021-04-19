package algorithms;

/**
 * 1832.判断句子是否为全字母句
 */
public class Problem1832 {

    class Solution {
        public boolean checkIfPangram(String sentence) {
            int count = 0;
            boolean[] flags = new boolean[26];

            for (char ch : sentence.toCharArray()) {
                int i = ch - 'a';
                if (flags[i]) {
                    continue;
                }

                flags[i] = true;
                count++;

                if (count == 26) {
                    return true;
                }
            }

            return false;
        }
    }


}