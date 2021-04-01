package algorithms;

import java.util.Arrays;

/**
 * 1663.具有给定数值的最小字符串
 */
class Problem1663 {
    public String getSmallestString(int n, int k) {
        int[] values = new int[n];
        Arrays.fill(values, 1);
        int diff = k - n;

        for (int i = n - 1; i >= 0; i--) {
            if (diff >= 26) {
                values[i] = 26;
                diff -= 25;
            } else {
                values[i] += diff;
                break;
            }
        }


        return toString(values);
    }

    private String toString(int[] values) {
        StringBuilder builder = new StringBuilder(values.length);
        for (int value : values) {
            builder.append((char) ('a' + value - 1));
        }
        return builder.toString();
    }
}
