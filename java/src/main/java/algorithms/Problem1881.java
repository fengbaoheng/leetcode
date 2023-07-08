package algorithms;

/**
 * 1881.插入后的最大值
 */
public class Problem1881 {
    class Solution {
        public String maxValue(String n, int x) {
            char[] arr = n.toCharArray();
            char charX = (char) ('0' + x);
            StringBuilder builder = new StringBuilder();
            boolean isFind = false;

            boolean isPositive = n.charAt(0) != '-';
            if (isPositive) {
                for (char c : arr) {
                    if (!isFind && c < charX) {
                        builder.append(charX);
                        isFind = true;
                    }
                    builder.append(c);
                }
            } else {
                builder.append('-');
                for (int i = 1; i < arr.length; i++) {
                    if (!isFind && arr[i] > charX) {
                        builder.append(charX);
                        isFind = true;
                    }
                    builder.append(arr[i]);
                }
            }

            if (!isFind) {
                builder.append(charX);
            }

            return builder.toString();
        }
    }
}