/*
 * @lc app=leetcode.cn id=921 lang=java
 *
 * [921] 使括号有效的最少添加
 */
class Solution {
    public int minAddToMakeValid(String S) {
        int length = S.length();
        if (length <= 1) {
            return length;
        }

        // 需要左右括号的数量
        int needRight = 0;
        int needLeft = 0;

        for (char ch : S.toCharArray()) {
            if (ch == '(') {
                needRight++;
            } else {
                if (needRight > 0) {
                    // 可以抵消一个'('
                    needRight--;
                } else {
                    // 当前没有'(', 则需额外添加
                    needLeft++;
                }
            }
        }

        return needLeft + needRight;
    }
}

