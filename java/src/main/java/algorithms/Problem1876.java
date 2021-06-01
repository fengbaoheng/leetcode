package algorithms;

/**
 * 1876.长度为三且各字符不同的子字符串
 */
public class Problem1876 {

    class Solution {
        public int countGoodSubstrings(String s) {
            int n = s.length();
            if (n < 3) {
                return 0;
            }

            int result = 0;

            for (int i = 0; i < n - 2; i++) {
                int a = s.charAt(i);
                int b = s.charAt(i + 1);
                int c = s.charAt(i + 2);

                if (a != b && a != c && b != c) {
                    result++;
                }
            }

            return result;
        }
    }


}