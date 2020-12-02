/*
 * @lc app=leetcode.cn id=438 lang=java
 *
 * [438] 找到字符串中所有字母异位词
 */

// @lc code=start
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new LinkedList<>();

        if (p.length() > s.length()) {
            return result;
        }

        int[] countP = new int[26];
        for (char c : p.toCharArray()) {
            countP[c - 'a']++;
        }

        // 统计位置0，直接右侧边界扩展至p.length()
        int[] countS = new int[26];
        for (int i = 0; i < p.length(); i++) {
            countS[s.charAt(i) - 'a']++;
        }

        // 判断是否需要添加
        if (isEquals(countS, countP)) {
            result.add(0);
        }

        // 滑动窗口
        for (int i = 1; i <= s.length() - p.length(); i++) {
            // 扩展右边界，收缩左边界
            countS[s.charAt(i - 1) - 'a']--;
            countS[s.charAt(i - 1 + p.length()) - 'a']++;

            // 判断是否符合条件
            if (isEquals(countS, countP)) {
                result.add(i);
            }
        }

        return result;
    }

    // 是否符合字母异位词
    private boolean isEquals(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

