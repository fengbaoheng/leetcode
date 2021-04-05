package algorithms;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 1816.截断句子
 */
public class Problem1816 {
    static class Solution {
        public String truncateSentence(String s, int k) {
            return Arrays.stream(s.split(" ")).limit(k).collect(Collectors.joining(" "));
        }
    }
}