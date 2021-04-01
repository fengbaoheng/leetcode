/*
 * @lc app=leetcode.cn id=1641 lang=java
 *
 * [1641] 统计字典序元音字符串的数目
 */

// @lc code=start
class Solution {
    private final char[] chars = {'a', 'e', 'i', 'o', 'u'};

    public int countVowelStrings(int n) {
        int result = 0;
        for (char ch : chars) {
            result += count(ch, n - 1);
        }
        return result;
    }

    private int count(char ch, int n) {
        if (n == 0) {
            return 1;
        }

        int result = 0;
        for (char c : chars) {
            if (c < ch) {
                continue;
            }

            result += count(c, n - 1);
        }
        return result;
    }
}
// @lc code=end

