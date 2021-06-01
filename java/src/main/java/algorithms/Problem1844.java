package algorithms;

/**
 * 1844.将所有数字用字符替换
 */
public class Problem1844 {

    class Solution {
        public String replaceDigits(String s) {
            int n = s.length();
            StringBuilder builder = new StringBuilder(n);

            int m = n / 2 * 2;
            for (int i = 0; i < m; i += 2) {
                char c = s.charAt(i);
                char cc = (char) (c + (s.charAt(i + 1) - '0'));
                builder.append(c);
                builder.append(cc);
            }

            for (int i = m; i < n; i++) {
                builder.append(s.charAt(i));
            }

            return builder.toString();
        }
    }

}