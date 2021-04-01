/*
 * @lc app=leetcode.cn id=1456 lang=java
 *
 * [1456] 定长子串中元音的最大数目
 */

// @lc code=start
import java.util.*;

class Solution {
    private static final Set<Character> VOWELS = new HashSet<>(5);

    static {
        VOWELS.add('a');
        VOWELS.add('e');
        VOWELS.add('i');
        VOWELS.add('o');
        VOWELS.add('u');
    }

    public int maxVowels(String s, int k) {
        int[] num = toNum(s);

        int maxCount = 0;
        for (int i = 0; i < k; i++) {
            maxCount += num[i];
        }

        int count = maxCount;
        for (int i = k; i < num.length; i++) {
            count -= num[i - k];
            count += num[i];

            maxCount = Math.max(maxCount, count);
        }
        
        return maxCount;
    }

    public int[] toNum(String s) {
        int len = s.length();
        int[] num = new int[len];
        for (int i = 0; i < len; i++) {
            num[i] = VOWELS.contains(s.charAt(i)) ? 1 : 0;
        }
        return num;
    }
}
// @lc code=end

