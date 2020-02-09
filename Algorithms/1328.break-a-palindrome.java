/*
 * @lc app=leetcode.cn id=1328 lang=java
 *
 * [1328] 破坏回文串
 */

// @lc code=start
class Solution {
    public String breakPalindrome(String palindrome) {
        int len = palindrome.length();
        if (len <= 1) {
            return "";
        }


        // 替换的位置和字符
        int index = -1;
        char replaceChar = ' ';

        // 从中间向两边依次查找可替换的字符
        // 由于是回文字符串, 因此可只判断一半的字符串
        int p = len / 2 - 1;
        while (p >= 0) {
            char ch = palindrome.charAt(p);
            if (ch != 'a') {
                index = p;
                replaceChar = 'a';
            }
            p--;
        }

        // 找不到可以变小的, 即整个字符串全为a
        // 为了满足返回非回文字符串的要求, 必须将1个字符替换成非a字符
        // 同时保证字典序最小, 因此将最后一个a替换为b
        if (index == -1) {
            index = len - 1;
            replaceChar = 'b';
        }

        StringBuilder stringBuilder = new StringBuilder(palindrome);
        stringBuilder.setCharAt(index, replaceChar);
        return stringBuilder.toString();
    }
}
// @lc code=end

