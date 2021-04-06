package algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * 1805.字符串中不同整数的数目
 */
public class Problem1805 {
    enum State {
        ALPHABET, ZERO, NUMBER
    }

    public static class Solution {
        public int numDifferentIntegers(String word) {
            Set<Long> integers = new HashSet<>();
            long num = 0;
            State state = State.ALPHABET;
            for (char c : word.toCharArray()) {
                boolean isZero = c == '0';
                boolean isNumber = c >= '0' && c <= '9';
                boolean isAlphabet = c >= 'a' && c <= 'z';
                if (state == State.ALPHABET) {
                    if (isZero) {
                        state = State.ZERO;
                    } else if (isNumber) {
                        num = c - '0';
                        state = State.NUMBER;
                    }
                } else if (state == State.ZERO) {
                    if (isAlphabet) {
                        // 结束零状态，添加零本身
                        state = State.ALPHABET;
                        integers.add(0L);
                    } else if (isNumber && !isZero) {
                        // 进入数字第一位
                        state = State.NUMBER;
                        num = c - '0';
                    }
                } else {
                    if (isAlphabet) {
                        // 数字结束
                        integers.add(num);
                        state = State.ALPHABET;
                    } else if (isNumber) {
                        // 延续数字
                        num = num * 10 + c - '0';
                    }
                }
            }

            // 结束状态
            if (state == State.NUMBER) {
                integers.add(num);
            } else if (state == State.ZERO) {
                integers.add(0L);
            }

            return integers.size();
        }
    }


}