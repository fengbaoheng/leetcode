/*
 * @lc app=leetcode.cn id=567 lang=java
 *
 * [567] 字符串的排列
 */

// @lc code=start
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        if (len1 > len2) {
            return false;
        }

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for (char c : s1.toCharArray()) {
            count1[c - 'a']++;
        }

        for (int i = 0; i < len1; i++) {
            char c = s2.charAt(i);
            count2[c - 'a']++;
        }

        if (isMatch(count1, count2)) {
            return true;
        }

        for (int i = len1; i < len2; i++) {
            int p = s2.charAt(i - len1) - 'a';
            int q = s2.charAt(i) - 'a';

            count2[p]--;
            count2[q]++;

            if (count1[p] == count2[p] || count1[q] == count2[q]) {
                if (isMatch(count1, count2)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean isMatch(int[] c1, int[] c2) {
        for (int i = 0; i < 26; i++) {
            if (c1[i] != c2[i]) {
                return false;
            }
        }
        return true;
    }

}
// @lc code=end

