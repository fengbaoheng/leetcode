package algorithms;

/**
 * 1869.哪种连续子字符串更长
 */
public class Problem1869 {

    class Solution {
        public boolean checkZeroOnes(String s) {
            int maxLen0 = 0;
            int maxLen1 = 0;

            int len = 0;
            int ch = ' ';
            for (char c : s.toCharArray()) {
                if (c == ch) {
                    len++;
                    continue;
                }

                if (ch == '1') {
                    maxLen1 = Math.max(maxLen1, len);
                } else {
                    maxLen0 = Math.max(maxLen0, len);
                }

                ch = c;
                len = 1;
            }

            if (ch == '1') {
                maxLen1 = Math.max(maxLen1, len);
            } else {
                maxLen0 = Math.max(maxLen0, len);
            }

            return maxLen1 > maxLen0;
        }
    }


}