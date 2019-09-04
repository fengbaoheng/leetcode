/*
 * @lc app=leetcode.cn id=917 lang=java
 *
 * [917] 仅仅反转字母
 */
class Solution {
    // 头尾双指针
    public String reverseOnlyLetters(String S) {
        char[] arr = S.toCharArray();
        int length = arr.length;

        int p = 0, q = length - 1;
        while (p < q) {
            // 搜索字符
            while (p < q && !isLetter(arr[p])) {
                p++;
            }

            while (p < q && !isLetter(arr[q])) {
                q--;
            }

            // 交换前后字符
            swap(arr, p, q);
            p++;
            q--;
        }

        return new String(arr);
    }

    private boolean isLetter(char ch) {
        return ('a' <= ch && ch <= 'z') || ('A' <= ch && ch <= 'Z');
    }

    private void swap(char[] arr, int p, int q) {
        char tmp = arr[p];
        arr[p] = arr[q];
        arr[q] = tmp;
    }
}
