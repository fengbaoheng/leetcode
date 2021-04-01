/*
 * @lc app=leetcode.cn id=459 lang=java
 *
 * [459] 重复的子字符串
 */

// @lc code=start
import java.util.*;
import java.util.stream.IntStream;

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int length = s.length();

        if (length <= 1) {
            return false;
        }

        Set<Integer> primeSet = getPrime(length);

        // 剔除自身长度
        primeSet.remove(length);

        // 逐个判断是否匹配
        for (Integer p : primeSet) {
            if (isRepeated(s, p)) {
                return true;
            }
        }

        return false;
    }

    // 验证子字符串是否匹配
    private boolean isRepeated(String s, int p) {
        int length = s.length();
        if (p >= length || p <= 0) {
            return false;
        }

        for (int i = 0; i < p; i++) {
            final char c = s.charAt(i);
            for (int j = i; j < length; j += p) {
                if (s.charAt(j) != c) {
                    return false;
                }
            }
        }

        return true;
    }

    // 返回n的所有质因数
    private Set<Integer> getPrime(final int n) {
        final Set<Integer> primeSet = new HashSet<>();

        int s = (int) Math.sqrt(n);
        IntStream.rangeClosed(1, s)
                .filter(i -> n % i == 0)
                .forEach(i -> {
                    primeSet.add(i);
                    primeSet.add(n / i);
                });

        return primeSet;
    }
}
// @lc code=end

