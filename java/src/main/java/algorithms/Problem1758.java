package algorithms;

/**
 * 1758.生成交替二进制字符串的最少操作数
 */
public class Problem1758 {

    class Solution {
        public int minOperations(String s) {
            int count0 = 0;
            int count1 = 0;

            for (char ch : s.toCharArray()) {
                int c0, c1;
                if (ch == '0') {
                    c0 = count1;
                    c1 = 1 + count0;
                } else {
                    c1 = count0;
                    c0 = 1 + count1;
                }

                count0 = c0;
                count1 = c1;
            }

            return Math.min(count0, count1);
        }
    }

}