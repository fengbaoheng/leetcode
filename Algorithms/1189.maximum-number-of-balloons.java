/*
 * @lc app=leetcode.cn id=1189 lang=java
 *
 * [1189] “气球” 的最大数量
 */
import java.util.stream.IntStream;

class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] counter = new int[26];

        for (char ch : text.toCharArray()) {
            int index = ch - 'a';
            counter[index]++;
        }

        return IntStream.of(
                counter['b' - 'a'],
                counter[0],
                Math.floorDiv(counter['l' - 'a'], 2),
                Math.floorDiv(counter['o' - 'a'], 2),
                counter['n' - 'a']
        )
                .min()
                .orElse(0);
    }
}

