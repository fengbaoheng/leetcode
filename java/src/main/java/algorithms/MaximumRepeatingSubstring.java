package algorithms;

import java.util.Arrays;

/**
 * 1668.最大重复子字符串
 */

class MaximumRepeatingSubstring {
    public int maxRepeating(String sequence, String word) {
        if (word.length() >= sequence.length()) {
            return word.equals(sequence) ? 1 : 0;
        }

        int k = 0;
        int[] dp = new int[sequence.length() + 1];
        for (int i = 0; i < sequence.length(); i++) {
            if (isMatch(sequence, i, word)) {
                int j = i + word.length();
                dp[j] = Math.max(dp[j], dp[i] + 1);
                k = Math.max(k, dp[j]);
            }
        }

        System.out.println(Arrays.toString(dp));

        return k;
    }

    /**
     * @return word是否在sequence[index]处开始匹配
     */
    private boolean isMatch(String sequence, int index, String word) {
        // 检测长度是否匹配
        if (index + word.length() > sequence.length()) {
            return false;
        }

        // 逐个字符进行匹配
        for (int i = 0; i < word.length(); i++) {
            if (sequence.charAt(index + i) != word.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}
